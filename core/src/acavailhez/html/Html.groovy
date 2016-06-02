package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.internal.HtmlEngine
import acavailhez.html.scope.HtmlScopeListener
import acavailhez.html.scope.HtmlMapDomScoped
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
    protected final HtmlMapDomScoped scope
    private final List<HtmlScopeListener> scopeListeners = new LinkedList<>();

    protected HtmlBuilder rootHtmlBuilder
    protected RawHtmlBuilder html
    protected EscapedHtmlBuilder escape

    private boolean rendered = false;

    private HtmlStyle style;

    protected abstract void build();

    public Html() {
        scope = new HtmlMapDomScoped()
        subscribeToScopeChanges(scope)
        rootHtmlBuilder = new HtmlBuilder()
        subscribeToScopeChanges(rootHtmlBuilder)
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

    HtmlMapDomScoped getScope() {
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

        prepareForNewScope()

        try {
            openTag(html.stringBuilder, tag, attrs)
            if (body != null) {
                body.call();
                closeTag(html.stringBuilder, tag)
            }
        }
        finally {
            // we force commit even if something failed
            // if the exception is never caught it does not matter
            // if the exception is caught it ensures a clean scope state
            commitToPreviousScope()
        }
    }
           // -- scope

    public void prepareForNewScope(){
         scopeListeners.each {it.prepareForNewScope()}
    }

    public void commitToPreviousScope(){
        scopeListeners.each {it.commitToPreviousScope()}
    }

    public void rollbackCurrentScope(){
        scopeListeners.each {it.rollbackCurrentScope()}
    }

    public void subscribeToScopeChanges(HtmlScopeListener scopeListener){
        scopeListeners.add(scopeListener)
    }
}