package acavailhez.html.builder

// JavascriptBuilder will store and scope javascript code
// javascript code will be isolated when written at the same scope
public class JavascriptBuilder {

    private final List<List<String>> scoped = new LinkedList<>()
    private List<String> scope = new LinkedList<>()

    public void leftShift(def s) {
        if (s == null) {
            return
        }
        String javascriptStatement = s.toString()
        javascriptStatement = javascriptStatement.trim()

        scope.add(javascriptStatement)
    }

    public void stash() {
        if (scope.size() > 0) {
            scoped.add(scope)
        }
        scope = new LinkedList<>()
    }

    public List<List<String>> getScoped() {
        return scoped
    }

    @Override
    public String toString() {
        return sb.toString()
    }
}
