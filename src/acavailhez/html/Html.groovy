package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScope
import acavailhez.html.traits.Html5Trait

// Render a piece of html
abstract class Html implements Html5Trait {

    // State local to the current DOM element
    protected final HtmlScope scope

    private HtmlBuilder htmlBuilder
    protected RawHtmlBuilder html
    protected EscapedHtmlBuilder escape

    private boolean rendered = false;

    private HtmlStyle style;

    protected abstract void build();

    public Html() {
        scope = new HtmlScope()
        htmlBuilder = new HtmlBuilder()
        scope.addScopable(htmlBuilder)
        html = htmlBuilder.getRawHtmlBuilder()
        escape = htmlBuilder.getEscapedHtmlBuilder()
    }

    RawHtmlBuilder html(Object input = null) {
        if (input) {
            html << input
        }
        return html
    }

    EscapedHtmlBuilder escape(Object input = null) {
        if (input) {
            escape << input
        }
        return escape
    }

    protected Html render() {
        if (rendered) return
        scope.prepareForNewScope()
        build()
        scope.commitToPreviousScope()
        rendered = true
        return this
    }

    protected String getRawHtml() {
        render()
        String result = htmlBuilder.toRawHtml()
        if (style == HtmlStyle.PRETTY) {
            result = HtmlUtils.tidy(result)
        }
        return result
    }

    public Html withStyle(HtmlStyle style) {
        this.style = style
        return this
    }

    // Generate a <tag attr="value">CONTENT</tag>
    void tag(String tag, Map attrs, Closure body) {

        scope.prepareForNewScope()

        html << "<${tag}"
        attrs?.each { Object k, Object v ->
            k = k?.toString()
            if (!v) return
            if (v instanceof Closure) {
                html << " $k=\""
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
            html << ' />'
        }

        if (body) {
            def bodyOut = body()
            if (bodyOut instanceof String) {
                html << bodyOut
            }
        }

        if (body) {
            html << "</${tag}>"
        }

        scope.commitToPreviousScope()
    }
}