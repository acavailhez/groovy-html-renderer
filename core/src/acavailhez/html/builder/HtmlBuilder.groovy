package acavailhez.html.builder

import acavailhez.html.scope.HtmlScopeListener
import groovy.transform.CompileStatic

@CompileStatic
class HtmlBuilder extends HtmlScopeListener<StringBuilder> {

    private final RawHtmlBuilder html = new RawHtmlBuilder()
    private final EscapedHtmlBuilder escape = new EscapedHtmlBuilder()

    public HtmlBuilder() {
        html.stringBuilder = getCurrentScope()
        escape.stringBuilder = getCurrentScope()
    }

    public RawHtmlBuilder getHtml() {
        return html
    }

    public EscapedHtmlBuilder getEscape() {
        return escape
    }

    @Override
    protected StringBuilder create() {
        StringBuilder stringBuilder = new StringBuilder()
        return stringBuilder
    }

    @Override
    protected StringBuilder merge(StringBuilder toMergeInto, StringBuilder objectToMerge) {
        return toMergeInto.append(objectToMerge)
    }

    @Override
    protected void afterScopeChanged(StringBuilder previousScope, StringBuilder newScope) {
        if (html) {
            html.stringBuilder = newScope
        }
        if (escape) {
            escape.stringBuilder = newScope
        }
    }

    public String getRawHtml() {
        return getCurrentScope().toString()
    }
}
