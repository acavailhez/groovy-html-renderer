package acavailhez.html.utils

import org.apache.commons.lang3.StringEscapeUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Entities
import org.jsoup.parser.Parser

import java.nio.charset.Charset

class HtmlUtils {

    // Escape the value of a html tag attribute
    public static String escapeHtmlAttribute(Object attribute) {
        if (attribute == null) {
            return ''
        }
        if (!attribute instanceof String) {
            return attribute
        }
        return (attribute as String).replaceAll('"', '&quot;')
    }

    // Escaoe text to be written in html
    public static String escapeTextToHtml(Object text) {
        if (text == null) {
            return ''
        }
        return StringEscapeUtils.escapeHtml4(text.toString())
    }

    public static Document getHtmlDocumentFromSource(String html, String baseUri = '') {
        Document doc
        if (html.contains('<html')) {
            doc = Jsoup.parse(html, baseUri);
        } else {
            doc = Jsoup.parse(html, '', Parser.xmlParser());
        }
        return doc
    }

    // beautify html
    public static String tidy(String html) {
        Document doc = getHtmlDocumentFromSource(html)
        doc.outputSettings().prettyPrint(true);
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.html);
        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
        doc.outputSettings().charset(Charset.forName('utf-8'));
        doc.outputSettings().indentAmount(1)

        return doc.html();
    }
}
