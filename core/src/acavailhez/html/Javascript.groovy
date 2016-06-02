package acavailhez.html

import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScopeListener
import groovy.transform.CompileStatic

// Contains javascript statements written during the building of the html
// Those get disconnected from the DOM and can be processed separately
// Typically defered to just before the </body>

@CompileStatic
public class Javascript extends HtmlScopeListener<List<String>> {

    @Override
    protected List<String> create() {
        return new LinkedList<String>();
    }

    @Override
    protected List<String> merge(List<String> toMergeInto, List<String> objectToMerge) {
        toMergeInto.addAll(objectToMerge)
        return toMergeInto
    }

    public void leftShift(def s) {
        if (s == null) {
            return
        }
        String javascriptStatement = s.toString()
        javascriptStatement = javascriptStatement.trim()
        getCurrentScope().add(javascriptStatement)
    }

    // Render to be included in html,
    // typically before </body>
    public void renderForHtml(RawHtmlBuilder html) {
        for (String statement : getCurrentScope()) {
            html << '<script>'
            html << statement
            html << '</script>'
        }
    }

    // Render to be sent via API
    // scopes the different statements
    public String getRawJavascript() {
        StringBuilder js = new StringBuilder()
        for (String statement : getCurrentScope()) {
            js << 'try{'
            js << statement
            js << '}catch(e){console.log(e)}'
        }
        return js.toString()
    }

    @Override
    void rollbackCurrentScope() {
        super.rollbackCurrentScope()
    }

    @Override
    void prepareForNewScope() {
        super.prepareForNewScope()
    }

    @Override
    void commitToPreviousScope() {
        super.commitToPreviousScope()
    }
}