package acavailhez.html

import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.traits.HtmlFragmentTrait
import groovy.transform.CompileStatic

// Piece of html,
// Can be rendered in different circumstances
// Typically asynchronously:
// the main HTML is rendered and calls back to render this fragment

@CompileStatic
abstract class HtmlFragment extends Html implements HtmlFragmentTrait {

    // Write javascript in context, it will be defered
    protected Javascript js
    private HtmlBuilder defer

    public HtmlFragment() {
        js = new Javascript()
        subscribeToScopeChanges(js)
        defer = new HtmlBuilder()
        subscribeToScopeChanges(defer)
    }

    public void defer(Closure toDefer) {
        prepareForNewScope()
        try {
            toDefer()
            defer.html << rootHtmlBuilder.html.toString()
            defer.commitToPreviousScope()
            defer.prepareForNewScope()
        }
        finally {
            rollbackCurrentScope()
        }
    }

    public String getRawJavascript() {
        return js.getRawJavascript()
    }

    public String getRawDeferredHtml() {
        return defer.getRawHtml()
    }

    // insert a fragment into another
    protected insert(HtmlFragment fragment, HtmlRenderMode mode) {
        if (mode != HtmlRenderMode.IMMEDIATE) {
            throw new Exception("mode not supported")
        }
        fragment.render()
        html << fragment.getRawHtml()
        defer.html << fragment.getRawDeferredHtml()
        js << fragment.getRawJavascript()
    }

}
