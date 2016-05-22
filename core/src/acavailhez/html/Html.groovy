package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.internal.HtmlEngine
import acavailhez.html.scope.HtmlScope
import acavailhez.html.traits.AttemptTrait
import acavailhez.html.traits.CaptureTrait
import acavailhez.html.traits.Html5Trait
import acavailhez.html.traits.ShortcutTrait
import acavailhez.html.utils.HtmlUtils
import groovy.transform.CompileStatic

// Render a piece of html
@CompileStatic
abstract class Html extends HtmlEngine implements
        Html5Trait,
        ShortcutTrait,
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
        if (rendered) return this
        scope.prepareForNewScope()
        build()
        scope.commitToPreviousScope()
        rendered = true
        return this
    }

    public String getRawHtml() {
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

        writeTag(html, tag, attrs, body)

        scope.commitToPreviousScope()
    }

}