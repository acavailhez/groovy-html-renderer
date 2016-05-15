package acavailhez.html.traits

import acavailhez.html.scope.HtmlScope

trait CaptureTrait extends HtmlTrait {

    // Runs the code but does not write to the main html
    // Instead you get the html in a String
    // This loses all other state (such as defers or javascript)
    String capture(Closure capturable) {
        HtmlScope scope = getScope()
        scope.prepareForNewScope()
        capturable()
        String html = getRootHtmlBuilder().html.toString()
        scope.rollbackCurrentScope()
        return html
    }

}


