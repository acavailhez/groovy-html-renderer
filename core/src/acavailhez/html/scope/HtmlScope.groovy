package acavailhez.html.scope

// Scoped state of the html
class HtmlScope {

    private List<Map<String, Object>> stack = new LinkedList<>()
    private List<HtmlScopable> scopables = new LinkedList<>()

    public void addScopable(HtmlScopable scopable) {
        scopables.add(scopable)
    }

    // save something in the current scope
    public void put(String key, Object value) {
        stack.last().put(key, value)
    }

    public Object get(String key) {
        Object value = null
        for (Map<String, Object> map : stack) {
            if (map.containsKey(key)) {
                value = map.get(key)
            }
        }
        return value
    }

    public void prepareForNewScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.prepareForNewScope()
        }
        stack.add(new HashMap<>())
    }

    public void commitToPreviousScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.commitToPreviousScope()
        }
        stack.pop()
    }

    public void rollbackCurrentScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.rollbackCurrentScope()
        }
        stack.pop()
    }

}