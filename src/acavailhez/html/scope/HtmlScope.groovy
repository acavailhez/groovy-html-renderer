package acavailhez.html.scope

// Scoped state of the html
class HtmlScope {

    private List<HtmlScopable> scopables = new LinkedList<>()

    public void addScopable(HtmlScopable scopable) {
        scopables.add(scopable)
    }

    public void prepareForNewScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.prepareForNewScope()
        }
    }

    public void commitToPreviousScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.commitToPreviousScope()
        }
    }

    public void rollbackCurrentScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.rollbackCurrentScope()
        }
    }

}
