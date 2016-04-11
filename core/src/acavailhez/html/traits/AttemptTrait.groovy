package acavailhez.html.traits

import acavailhez.html.scope.HtmlScope
import groovy.transform.CompileStatic

@CompileStatic
trait AttemptTrait extends HtmlTrait {

    // Attempt to execute the code, if fails, rollsback and execute the fallback
    void attempt(Closure main, Closure fallback) {
        HtmlScope scope = getScope()
        scope.prepareForNewScope()
        try {
            main()
            scope.commitToPreviousScope()
        }
        catch (Throwable e) {
            scope.rollbackCurrentScope()
            scope.prepareForNewScope()
            // This might throw
            if (fallback) {
                fallback(e)
            }
            scope.commitToPreviousScope()
        }
    }

    // Shortcut
    void attempt(Closure main) {
        attempt(main, null)
    }


}


