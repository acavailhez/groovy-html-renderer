package acavailhez.html

trait Html5Trait {
    abstract void tag(String tag, Map attrs, Closure body)

    void div(Closure body) {
        tag('div', [:], body)
    }

    void div(Map attrs, Closure body) {
        tag('div', attrs, body)
    }

}
