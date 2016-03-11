package acavailhez.html.traits

abstract trait HtmlTrait {

    abstract void tag(String tag, Map attrs, Closure body)

}
