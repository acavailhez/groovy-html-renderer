package acavailhez.html.builder

import acavailhez.html.utils.HtmlUtils

// append string directly
class EscapedHtmlBuilder {

    private StringBuilder stringBuilder

    public EscapedHtmlBuilder() {
        // Nothing to do
    }

    void setStringBuilder(StringBuilder stringBuilder) {
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
