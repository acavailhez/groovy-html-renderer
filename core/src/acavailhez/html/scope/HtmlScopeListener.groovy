package acavailhez.html.scope

import groovy.transform.CompileStatic

// HtmlScoped will hold an SCOPED_OBJECT instance for each DOM tag open/close
//
// When a new DOM tag open, a new SCOPED_OBJECT is created
// when the DOM tag closes, this object is committed and saved with all the other committed SCOPED_OBJECT
// it is possible to rollback the current scope and drop all the SCOPED_OBJECT that were committed during the current DOM scope
@CompileStatic
abstract class HtmlScopeListener<SCOPED_OBJECT> {

    // Current stack of scoped objects, keeping track of what has been open for all current open DOM levels
    // If the scope currently looks like this (<< means "create new scoped object):
    // {
    //   << A
    //  {
    //    << B
    //   {
    //     << C
    //   }
    //   {
    //     << D
    //     rollback
    //   }
    //   {
    //    << E
    //
    // then the stack will look like:
    // [
    //  A,
    //  B+C
    //  E
    // ]
    //
    // where B+C have been merged together, and D is gone
    //
    protected List<SCOPED_OBJECT> stack = [];

    // Create a new scoped object for the current scope
    protected abstract SCOPED_OBJECT create();

    // Merge the current scope (most likely in the previous scope)
    protected abstract SCOPED_OBJECT merge(SCOPED_OBJECT toMergeInto, SCOPED_OBJECT objectToMerge);

    protected HtmlScopeListener() {
        // Open the "global" scope
        prepareForNewScope();
    }

    public SCOPED_OBJECT getCurrentScope() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty, this probably means that it was committed or rolled back one time too many")
        }
        return stack.get(stack.size() - 1);
    }

    private SCOPED_OBJECT popCurrentScope() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty, this probably means that it was committed or rolled back one time too many")
        }
        return stack.remove(stack.size() - 1);
    }

    public void prepareForNewScope() {
        SCOPED_OBJECT currentScope = null;
        if (stack.size() > 0) {
            currentScope = getCurrentScope()
        }
        SCOPED_OBJECT newScope = create()
        stack.add(newScope)
        afterScopeChanged(currentScope, newScope)
    }

    public void commitToPreviousScope() {
        SCOPED_OBJECT currentScope = popCurrentScope();

        // Merge the current scope into the previous one
        SCOPED_OBJECT previousScope = getCurrentScope();
        SCOPED_OBJECT merged = merge(previousScope, currentScope)

        // Replace the previous scope by the merged object
        if (merged != previousScope) {
            popCurrentScope()
            stack.addAll(merged)
        }
        afterScopeChanged(currentScope, previousScope)
    }

    public void rollbackCurrentScope() {
        SCOPED_OBJECT currentScope = popCurrentScope();
        afterScopeChanged(currentScope, getCurrentScope())
    }

    protected void afterScopeChanged(SCOPED_OBJECT previousScope, SCOPED_OBJECT newScope) {
        // override if you want to listen to scope change events
    }

}
