import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlUtils
import jodd.http.HttpRequest
import jodd.http.HttpResponse
import org.jsoup.nodes.Attribute
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode

import java.lang.reflect.Method

// Convert a page to a parametrized velocity page
// To generate code for performance tests
class HtmlToVelocityConverter {

    public static int mapIndex = 0;

    public static String convertHtmlUrlToVelocityCode(String urlString) {
        HttpResponse response = new HttpRequest().get(urlString).send()
        URL url = new URL(urlString)
        String baseUri = url.getProtocol() + "://" + url.getHost() + ':' + url.getPort();
        return convertHtmlStringToGroovyCode(response.bodyText(), baseUri)
    }

    public static String convertHtmlStringToGroovyCode(String html, String baseUri = '') {

        Document doc = HtmlUtils.getHtmlDocumentFromSource(html, baseUri)
        Element body = recursivelyFindBody(doc.children())
        StringBuffer template = new StringBuffer()
        StringBuffer code = new StringBuffer()
        code << 'VelocityContext context = new VelocityContext();\n'
        int indent = 0
        List<Node> nodes
        if (body) {
            nodes = body.childNodes()
        } else {
            nodes = doc.childNodes()
        }
        recursiveWriteGroovyCode(template, code, nodes, indent)
        return code.toString() + '\n\n' + template.toString()
    }

    private static Element recursivelyFindBody(List<Element> elements) {
        Element body = null
        elements.each { Element element ->
            if (element.tagName() == 'body') {
                body = element
            } else {
                body = recursivelyFindBody(element.children())
            }
        }
        return body
    }

    private static void recursiveWriteGroovyCode(StringBuffer template, StringBuffer code, List<Node> nodes, int indent) {
        nodes.each { Node node ->
            String tab = new String(new char[indent]).replace("\0", ' ');
            if (node instanceof TextNode) {
                TextNode textNode = node as TextNode
                if (!textNode.isBlank()) {
                    String variableName = "a" + (mapIndex++)
                    code << 'context.put("' << variableName << '", "' << textNode.text() << '");\n'
                    template << '$' + variableName
                }
            } else if (node instanceof Element) {
                Element element = node as Element
                // Find corresponding methods
                List<Method> methods = Html5Trait.getMethods().findAll { it.name == element.tagName() }
                if (methods.size() <= 0) {
                    println 'unknown tag:' + element.tagName()
                } else {
                    template.append("<");
                    template.append(element.tagName());
                    element.attributes().each { Attribute attr ->
                        String escaped = HtmlUtils.escapeHtmlAttribute(attr.getValue());
                        template.append(" ");
                        template.append(attr.getKey());
                        template.append("=\"");
                        template.append(escaped);
                        template.append("\"");
                    }
                    template.append(">");
                    recursiveWriteGroovyCode(template, code, element.childNodes(), indent + 1)
                    template.append("</");
                    template.append(element.tagName());
                    template.append(">\n");

                }
            } else {
                println "Unknown jsoup class:" + node.class
            }
        }
    }

}
