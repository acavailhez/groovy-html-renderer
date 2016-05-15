package acavailhez.html

import acavailhez.html.traits.HtmlFragmentTrait

// Piece of html,
// Can be rendered in different circumstances
// Typically asynchronously:
// the main HTML is rendered and calls back to render this fragment
abstract class HtmlFragment extends Html implements HtmlFragmentTrait{

    // Write javascript in context, it will be defered
    protected Javascript js
    String deferredHtml = ''

    public HtmlFragment() {
        js = new Javascript()
        scope.addScopable(js)
    }

    public void defer(Closure toDefer) {
        scope.prepareForNewScope()
        toDefer()
        deferredHtml += rootHtmlBuilder.html.toString()
        scope.rollbackCurrentScope()
    }

    public String getRawJavascript() {
        return js.getRawJavascript()
    }

    public String getRawDeferredHtml() {
        return deferredHtml
    }

    // insert a fragment into another
    protected insert(HtmlFragment fragment, HtmlRenderMode mode){
        if(mode != HtmlRenderMode.IMMEDIATE){
            throw new Exception("mode not supported")
        }
        fragment.render()
        html << fragment.getRawHtml()
        deferredHtml += fragment.getRawDeferredHtml()
        js << fragment.getRawJavascript()
    }

}
