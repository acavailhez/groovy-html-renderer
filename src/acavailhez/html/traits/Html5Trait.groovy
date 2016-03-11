package acavailhez.html.traits

trait Html5Trait extends HtmlTrait {
    abstract void tag(String tag, Map attrs, Closure body)

    void div(Closure body) {
        tag('div', [:], body)
    }

    void div(Map attrs, Closure body) {
        tag('div', attrs, body)
    }

    public void p(Closure body) {
        tag('p', [:], body)
    }

    public void p(Map attrs, Closure body) {
        tag('p', attrs, body)
    }

    public void span(Closure body) {
        tag('span', [:], body)
    }

    public void span(Map attrs, Closure body) {
        tag('span', attrs, body)
    }

}
