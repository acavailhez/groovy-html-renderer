package acavailhez.html.builder
// append string directly
class RawHtmlBuilder {

    private  StringBuilder stringBuilder

    public RawHtmlBuilder() {
        // Nothing to do
    }

    void setStringBuilder(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder
    }

    public RawHtmlBuilder leftShift(def s) {
        if (s == null) {
            return this
        }
        stringBuilder << s.toString()
        return this
    }

    @Override
    public String toString() {
        return stringBuilder.toString()
    }
}
