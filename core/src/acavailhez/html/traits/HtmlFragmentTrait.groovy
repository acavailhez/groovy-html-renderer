package acavailhez.html.traits

import groovy.transform.CompileStatic

@CompileStatic
abstract trait HtmlFragmentTrait {

    abstract void defer(Closure toDefer)

}
