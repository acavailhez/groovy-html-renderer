package acavailhez.html.internal;

import acavailhez.html.utils.HtmlUtils;

import java.util.Map;
import java.util.Set;

// Everything heavy is coded in java for performances
public class HtmlEngine {

    public static void openTag(StringBuilder html, String tagName, Map attrs) {
        html.append("<");
        html.append(tagName);
        if (attrs != null) {
            Set<Object> keyObjects = attrs.keySet();
            for (Object keyO : keyObjects) {
                String key = keyO.toString();
                Object value = attrs.get(key);
                if (value != null) {
                    String escaped = HtmlUtils.escapeHtmlAttribute(value);
                    html.append(" ");
                    html.append(key);
                    html.append("=\"");
                    html.append(escaped);
                    html.append("\"");
                }
            }
        }
        html.append(">");
    }

    public static void closeTag(StringBuilder html, String tagName) {
        html.append("</");
        html.append(tagName);
        html.append(">");
    }
}
