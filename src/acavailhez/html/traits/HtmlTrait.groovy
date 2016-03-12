package acavailhez.html.traits

abstract trait HtmlTrait {

    abstract void tag(String tag, Map attrs, Closure body)

    abstract void html(Object input)

    abstract void escape(Object input)

}
