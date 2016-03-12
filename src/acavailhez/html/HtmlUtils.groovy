package acavailhez.html

import org.apache.commons.lang3.StringEscapeUtils


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
}
