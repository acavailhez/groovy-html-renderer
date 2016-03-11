package acavailhez.html.builder

// append string directly
class RawHtmlBuilder {

    private final StringBuilder stringBuilder

    public RawHtmlBuilder(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder
    }

    public RawHtmlBuilder leftShift(def s) {
        if (s == null) {
            // a null string has been passed, do nothing
            return this
        }
        //sb << containerHtmlRenderer.getCurrentTabulations()
        stringBuilder << s.toString()
        //sb << containerHtmlRenderer.endLine()
        return this
    }

    @Override
    public String toString() {
        return stringBuilder.toString()
    }
}
