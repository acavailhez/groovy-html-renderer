package acavailhez.html

class HtmlUtils {

    public static String escapeHtmlAttribute(Object attribute) {
        if (attribute == null) {
            return ''
        }
        if (!attribute instanceof String) {
            return attribute
        }
        return (attribute as String).replaceAll('"', '&quot;')
    }

}
