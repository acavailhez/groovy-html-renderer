package acavailhez.html

// Piece of html,
// Can be rendered in different circumstances
// Typically asynchronously:
// the main HTML is rendered and calls back to render this fragment
abstract class HtmlFragment extends Html {

    Javascript js;

    public HtmlFragment() {
        js = new Javascript()
        scope.addScopable(js)
    }

}
