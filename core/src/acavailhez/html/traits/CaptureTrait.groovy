package acavailhez.html.traits

import groovy.transform.CompileStatic

@CompileStatic
trait CaptureTrait extends HtmlTrait {

    // Runs the code but does not write to the main html
    // Instead you get the html in a String
    // This loses all other state (such as defers or javascript)
    String capture(Closure capturable) {
        prepareForNewScope()
        capturable()
        String html = getRootHtmlBuilder().html.toString()
        rollbackCurrentScope()
        return html
    }

}


