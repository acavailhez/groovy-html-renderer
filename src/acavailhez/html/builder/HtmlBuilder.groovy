package acavailhez.html.builder

abstract class HtmlBuilder {

    private final StringBuilder sb = new StringBuilder()

    abstract protected void append();

    public HtmlBuilder leftShift(def s) {
        if (s == null) {
            // a null string has been passed, do nothing
            return this
        }
        //sb << containerHtmlRenderer.getCurrentTabulations()
        sb << s.toString()
        //sb << containerHtmlRenderer.endLine()
        return this
    }

    @Override
    public String toString() {
        return sb.toString()
    }
}
