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

    // Accessors in current attributes
    abstract void scopeAttrs(Map attrs);

    abstract Object optAttr(String key);

    abstract <T> T optAttr(String key, Class<T> classToCast);

    abstract <T> T optAttr(String key, Class<T> classToCast, T defaultValue);

    abstract Object getAttr(String key) throws IllegalArgumentException;

    abstract <T> T getAttr(String key, Class<T> classToCast) throws IllegalArgumentException;

    abstract <T> T getAttr(String key, Class<T> classToCast, T defaultValue) throws IllegalArgumentException;
}
