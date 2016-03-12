package acavailhez.html.traits

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder

abstract trait HtmlTrait {

    abstract void tag(String tag, Map attrs, Closure body)

    abstract RawHtmlBuilder html(Object input)

    abstract RawHtmlBuilder html()

    abstract EscapedHtmlBuilder escape(Object input)

    abstract EscapedHtmlBuilder escape()

}
