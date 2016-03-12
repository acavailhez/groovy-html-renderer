package acavailhez.html.builder

import acavailhez.html.scope.HtmlScopable

class HtmlBuilder implements HtmlScopable {

    private final Stack<StringBuilder> stringBuilderStack = new Stack<>()
    private final RawHtmlBuilder html = new RawHtmlBuilder()
    private final EscapedHtmlBuilder escape = new EscapedHtmlBuilder()

    private StringBuilder currentStringBuilder

    public HtmlBuilder() {
        // Nothing to do
    }

    public RawHtmlBuilder getHtml() {
        return html
    }

    public EscapedHtmlBuilder getEscape() {
        return escape
    }

    @Override
    void prepareForNewScope() {
        if (currentStringBuilder != null) {
            stringBuilderStack.push(currentStringBuilder)
        }
        currentStringBuilder = new StringBuilder()
        html.setStringBuilder(currentStringBuilder)
        escape.setStringBuilder(currentStringBuilder)
    }

    @Override
    void commitToPreviousScope() {
        if (!stringBuilderStack.isEmpty()) {
            StringBuilder previousStringBuilder = stringBuilderStack.pop()
            previousStringBuilder.append(currentStringBuilder)
            currentStringBuilder = previousStringBuilder
            html.setStringBuilder(currentStringBuilder)
            escape.setStringBuilder(currentStringBuilder)
        }
        else{
            // We got to the root, nothing to do
        }
    }

    @Override
    void rollbackCurrentScope() {
        if (!stringBuilderStack.isEmpty()) {
            StringBuilder previousStringBuilder = stringBuilderStack.pop()
            currentStringBuilder = previousStringBuilder
            html.setStringBuilder(currentStringBuilder)
            escape.setStringBuilder(currentStringBuilder)
        }
        else{
            // drop current
            currentStringBuilder = new StringBuilder()
        }
    }

    public String getRawHtml() {
        return currentStringBuilder.toString()
    }
}
