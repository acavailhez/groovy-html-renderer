package acavailhez.html.traits

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.HtmlBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.scope.HtmlMapDomScoped
import acavailhez.html.scope.HtmlScopable
import acavailhez.html.scope.HtmlScope
import acavailhez.html.scope.HtmlScopeListener
import groovy.transform.CompileStatic

@CompileStatic
abstract trait HtmlTrait {

    abstract void tag(String tag, Map attrs, Closure body)

    abstract HtmlMapDomScoped getScope()

    abstract HtmlBuilder getRootHtmlBuilder()

    abstract RawHtmlBuilder html(Object input)

    abstract RawHtmlBuilder getHtml()

    abstract EscapedHtmlBuilder escape(Object input)

    abstract EscapedHtmlBuilder getEscape()

    // Scope

    abstract void prepareForNewScope();

    abstract void commitToPreviousScope();

    abstract void rollbackCurrentScope();

    abstract void subscribeToScopeChanges(HtmlScopeListener scopable);
}