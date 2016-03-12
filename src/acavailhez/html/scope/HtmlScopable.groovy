package acavailhez.html.scope

// Classes implementing HtmlScopable will hold some html state, scoped to a DOM element
interface HtmlScopable {

    // Save the current scope and prepareForNewScope for a new one
    void prepareForNewScope()

    // Commit the current scope and re-scope down one level
    void commitToPreviousScope()

    // Abandon changes to the current scope
    void rollbackCurrentScope()
}
