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

class HtmlToGroovyConverter {

    public static String convertHtmlUrlToGroovyCode(String urlString) {
        HttpResponse response = new HttpRequest().get(urlString).send()
        URL url = new URL(urlString)
        String baseUri = url.getProtocol() + "://" + url.getHost() + ':' + url.getPort();
        return convertHtmlStringToGroovyCode(response.bodyText(), baseUri)
    }

    public static String convertHtmlStringToGroovyCode(String html, String baseUri = '') {

        Document doc = HtmlUtils.getHtmlDocumentFromSource(html, baseUri)
        Element body = recursivelyFindBody(doc.children())
        StringBuffer buffer = new StringBuffer()
        int indent = 0
        List<Node> nodes
        if (body) {
            nodes = body.childNodes()
        } else {
            nodes = doc.childNodes()
        }
        recursiveWriteGroovyCode(buffer, nodes, indent)
        return buffer.toString()
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

    private static void recursiveWriteGroovyCode(StringBuffer buffer, List<Node> nodes, int indent) {
        nodes.each { Node node ->
            String tab = new String(new char[indent]).replace("\0", ' ');
            if (node instanceof TextNode) {
                TextNode textNode = node as TextNode
                if (!textNode.isBlank()) {
                    buffer.append(tab)
                    buffer.append('escape << "')
                    buffer.append(textNode.text().trim()) // todo escape "
                    buffer.append('"')
                    buffer.append(System.lineSeparator())
                }
            } else if (node instanceof Element) {
                Element element = node as Element
                // Find corresponding methods
                List<Method> methods = Html5Trait.getMethods().findAll { it.name == element.tagName() }
                if (methods.size() <= 0) {
                    println 'unknown tag:' + element.tagName()
                } else {

                    buffer.append(tab)
                    buffer.append(element.tagName())
                    if (element.attributes().size() > 0) {
                        buffer.append('(')
                        element.attributes().each { Attribute attr ->
                            if (!attr.equals(element.attributes().first())) {
                                buffer.append(', ')
                            }
                            if (attr.getKey().contains('-')) {
                                buffer.append('\'')
                                buffer.append(attr.getKey())
                                buffer.append('\'')
                            } else {
                                buffer.append(attr.getKey())
                            }
                            buffer.append(':\'')
                            buffer.append(attr.getValue())
                            buffer.append('\'')
                        }
                        buffer.append(')')
                    } else {
                        boolean allowsOnlyClosure = methods.find { it.parameterCount == 1 && it.parameterTypes[0] == Closure.class }
                        if (!allowsOnlyClosure) {
                            buffer.append('([:])')
                        }
                    }
                    boolean allowsClosure = methods.find { it.parameterTypes.find { it == Closure.class } }
                    if (allowsClosure) {
                        buffer.append('{')
                        buffer.append(System.lineSeparator())
                        buffer.append(tab)
                        recursiveWriteGroovyCode(buffer, element.childNodes(), indent + 1)
                        buffer.append(tab)
                        buffer.append('}')
                        buffer.append(System.lineSeparator())
                    }
                }
            } else {
                println "Unknown jsoup class:" + node.class
            }
        }
    }

}
