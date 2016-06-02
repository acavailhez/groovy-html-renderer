package acavailhez.html.traits

import groovy.transform.CompileStatic

@CompileStatic
trait AttemptTrait extends HtmlTrait {

    // Attempt to execute the code, if fails, rollsback and execute the fallback
    void attempt(Closure main, Closure fallback) {
        prepareForNewScope()
        try {
            main()
            commitToPreviousScope()
        }
        catch (Throwable e) {
            rollbackCurrentScope()
            if (fallback) {
                prepareForNewScope()
                try {
                    // This might throw
                    fallback(e)
                }
                finally {
                    commitToPreviousScope()
                }
            }
        }
    }

    // Shortcut
    void attempt(Closure main) {
        attempt(main, null)
    }


}


