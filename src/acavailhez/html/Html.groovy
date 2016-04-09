package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScope
import acavailhez.html.traits.CaptureTrait
import acavailhez.html.traits.Html5Trait
import acavailhez.html.traits.AttemptTrait
import acavailhez.html.traits.ShortcutTrait

// Render a piece of html
abstract class Html implements
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

        scopeAttrs(attrs)

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
        html << '>'
        if (body) {
            body()
            html << "</${tag}>"
        }

        scope.commitToPreviousScope()
    }

    // Accessors of current attributes
    // Those will only work if attributes have been scoped

    void scopeAttrs(Map attrs) {
        scope.put('_attrs', attrs)
    }

    public Object optAttr(String key) {
        return optAttr(key, Object)
    }

    public <T> T optAttr(String key, Class<T> classToCast, T defaultValue = null) {
        Map attrs = (Map) getScope().get('_attrs')
        return HtmlUtils.optAttribute(attrs, key, classToCast, defaultValue)
    }

    public Object getAttr(String key) {
        return getAttr(key, Object)
    }

    public <T> T getAttr(String key, Class<T> classToCast, T defaultValue = null) throws IllegalArgumentException {
        T value = optAttr(key, classToCast, defaultValue)
        if (value == null) {
            throw new IllegalArgumentException("Missing attribute '" + key + "'")
        }
        return value
    }

}