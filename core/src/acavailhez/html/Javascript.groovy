package acavailhez.html

import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScopable
import groovy.transform.CompileStatic

// Contains javascript statements written during the building of the html
// Those get disconnected from the DOM and can be processed separately
// Typically defered to just before the </body>

@CompileStatic
public class Javascript implements HtmlScopable {

    // scoped statements
    List<List<String>> scopedStatements = new LinkedList<>()
    private List<String> currentScopedStatements

    public void leftShift(def s) {
        if (s == null) {
            return
        }
        String javascriptStatement = s.toString()
        javascriptStatement = javascriptStatement.trim()

        currentScopedStatements.add(javascriptStatement)
    }

    @Override
    void prepareForNewScope() {
        currentScopedStatements = new LinkedList<>()
    }

    @Override
    void commitToPreviousScope() {
        if (currentScopedStatements.size() > 0) {
            scopedStatements.add(currentScopedStatements)
        }
        currentScopedStatements = new LinkedList<>()
    }

    @Override
    void rollbackCurrentScope() {
        currentScopedStatements = new LinkedList<>()
    }

    // Render to be included in html,
    // typically before </body>
    public void renderForHtml(RawHtmlBuilder html) {
        if (scopedStatements.size() > 0) {
            for (List<String> statements : scopedStatements) {
                html << '<script>'
                for (String statement : statements) {
                    html << statement
                }
                html << '</script>'
            }
        }
    }

    // Render to be sent via API
    // scopes the different statements
    public String getRawJavascript() {
        StringBuilder js = new StringBuilder()
        for (List<String> statements : scopedStatements) {
            js << 'try{'
            for (String statement : statements) {
                js << statement
            }
            js << '}catch(e){console.log(e)}'
        }
        return js.toString()
    }

}