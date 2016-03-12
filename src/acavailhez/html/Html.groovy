package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScope
import acavailhez.html.traits.CaptureTrait
import acavailhez.html.traits.Html5Trait
import acavailhez.html.traits.AttemptTrait

// Render a piece of html
abstract class Html implements
        Html5Trait,
        AttemptTrait,
        CaptureTrait {

    // State local to the current DOM element
    protected final HtmlScope scope

    protected HtmlBuilder rootHtmlBuilder
    protected RawHtmlBuilder html
    protected EscapedHtmlBuilder escape

    private boolean rendered = false;

    private HtmlStyle style;

    protected abstract void build();

    public Html() {
        scope = new HtmlScope()
        rootHtmlBuilder = new HtmlBuilder()
        scope.addScopable(rootHtmlBuilder)
        html = rootHtmlBuilder.getHtml()
        escape = rootHtmlBuilder.getEscape()
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

    HtmlBuilder getRootHtmlBuilder() {
        return rootHtmlBuilder
    }

    RawHtmlBuilder getHtml() {
        return html
    }

    EscapedHtmlBuilder getEscape() {
        return escape
    }

    HtmlScope getScope() {
        return scope
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
        String result = rootHtmlBuilder.getRawHtml()
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
            body()
            html << "</${tag}>"
        } else {
            html << ' />'
        }

        scope.commitToPreviousScope()
    }
}