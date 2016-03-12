package acavailhez.html
// Piece of html,
// Can be rendered in different circumstances
// Typically asynchronously:
// the main HTML is rendered and calls back to render this fragment
abstract class HtmlFragment extends Html {

    // Write javascript in context, it will be defered
    protected Javascript js
    String deferredHtml = ''

    public HtmlFragment() {
        js = new Javascript()
        scope.addScopable(js)
    }

    protected void defer(Closure toDefer) {
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

}
