package acavailhez.html

import acavailhez.html.builder.RawHtmlBuilder

// Render a piece of html
abstract class Html implements Html5Trait{

    protected RawHtmlBuilder html;
    protected RawHtmlBuilder escape;
    protected RawHtmlBuilder js;

    private HtmlStyle style;
    private boolean firstLine = true;
    private int currentTabulations = 0;

    public abstract void build();

    public String render() {
        StringBuilder stringBuilder = new StringBuilder()
        html = new RawHtmlBuilder(stringBuilder)
        escape = new RawHtmlBuilder(stringBuilder)
        js = new RawHtmlBuilder(stringBuilder)
        build()
        return html.toString()
    }

    // generate a <tag attr="value">CONTENT</tag>
    public void tag(String tag, Map attrs, Closure body) {

        if (!firstLine) {
            html << endLine()
        } else {
            firstLine = false
        }
        html << getCurrentTabulations()

        html << "<${tag}"
        attrs?.each { Object k, Object v ->
            k = k?.toString()
            if (!v) return
            if (v instanceof Closure) {
                out.appendWithoutStyling(" $k=\"")
                (v as Closure)()
                html << '"'
            } else {
                String escaped = HtmlUtils.escapeHtmlAttribute(v)
                html << " $k=\"$escaped\""
            }
        }
        if (body) {
            html << '>'
        } else {
            html << '/>'
        }
        currentTabulations++

        if (body) {
            def bodyOut = body()
            if (bodyOut instanceof String) {
                html << bodyOut
            }
        }
        currentTabulations--

        if (body) {
            html << "</${tag}>"
            html << endLine()
            html << getCurrentTabulations(-1)
        }
    }

    private String endLine() {
        if (style == HtmlStyle.PRETTY) {
            return System.lineSeparator()
        }
        return ''
    }

    private String getCurrentTabulations(int modifier = 0) {
        if (style == HtmlStyle.PRETTY) {
            int i = currentTabulations + modifier
            StringBuilder sb = new StringBuilder()
            while (i-- > 0) {
                sb.append(' ')
            }
            return sb.toString()
        }
        return ''
    }


}