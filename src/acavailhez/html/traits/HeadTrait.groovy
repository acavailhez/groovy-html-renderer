package acavailhez.html.traits

trait HeadTrait extends HtmlTrait {
    abstract void tag(String tag, Map attrs, Closure body)

    void meta(Map attrs) {
        tag('meta', attrs, null)
    }
}
