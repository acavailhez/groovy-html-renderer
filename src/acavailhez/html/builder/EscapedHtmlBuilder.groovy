package acavailhez.html.builder

import acavailhez.html.HtmlUtils

// append string directly
class EscapedHtmlBuilder {

    private final StringBuilder stringBuilder

    public EscapedHtmlBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder
    }

    public EscapedHtmlBuilder leftShift(def s) {
        if (s == null) {
            return this
        }
        stringBuilder << HtmlUtils.escapeTextToHtml(s)
        return this
    }

    @Override
    public String toString() {
        return stringBuilder.toString()
    }
}
