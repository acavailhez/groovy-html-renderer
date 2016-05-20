package acavailhez.html.internal;

import acavailhez.html.builder.RawHtmlBuilder;
import acavailhez.html.utils.HtmlUtils;
import groovy.lang.Closure;

import java.util.Map;
import java.util.Set;

// Everything heavy is coded in java for performances
public class HtmlEngine {

    // Generate a <tag attr="value">CONTENT</tag>
    protected static void writeTag(RawHtmlBuilder html, String tagName, Map<Object, Object> attrs, Closure body) {

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
        if (body != null) {
            body.call();
            html.append("</");
            html.append(tagName);
            html.append(">");
        }
    }
}
