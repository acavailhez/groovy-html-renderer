package acavailhez.html.traits

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlScope

abstract trait HtmlTrait {

    abstract void tag(String tag, Map attrs, Closure body)

    abstract HtmlScope getScope()

    abstract HtmlBuilder getRootHtmlBuilder()

    abstract RawHtmlBuilder html(Object input)

    abstract RawHtmlBuilder getHtml()

    abstract EscapedHtmlBuilder escape(Object input)

    abstract EscapedHtmlBuilder getEscape()

}
