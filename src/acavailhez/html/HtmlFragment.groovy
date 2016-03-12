package acavailhez.html

import acavailhez.html.builder.HtmlBuilder

// Piece of html,
// Can be rendered in different circumstances
// Typically asynchronously:
// the main HTML is rendered and calls back to render this fragment
abstract class HtmlFragment extends Html {

    // Write javascript in context, it will be defered
    Javascript js
    // If you want to write some html to be appended at the end of the document
    // (typically a modal, to be isolated at the root of DOM for css reasons)
    HtmlBuilder deferHtmlBuilder

    public HtmlFragment() {
        js = new Javascript()
        scope.addScopable(js)
        deferHtmlBuilder = new HtmlBuilder()
        scope.addScopable(deferHtmlBuilder)
    }

    protected void defer(Closure toDefer){
        html = deferHtmlBuilder.html
        escape = deferHtmlBuilder.escape
        toDefer()
        html = rootHtmlBuilder.html
        escape = rootHtmlBuilder.escape
    }

    public String getRawJavascript() {
        return js.getRawJavascript()
    }

    public String getRawDeferredHtml(){
        return deferHtmlBuilder.toRawHtml()
    }

}
