package acavailhez.html

import acavailhez.html.builder.EscapedHtmlBuilder
import acavailhez.html.builder.JavascriptBuilder
import acavailhez.html.builder.RawHtmlBuilder
import acavailhez.html.traits.Html5Trait

// Render a piece of html
abstract class Html implements Html5Trait {

    protected RawHtmlBuilder html;
    protected EscapedHtmlBuilder escape;
    protected JavascriptBuilder js;

    private HtmlStyle style;

    protected abstract void build();

    void html(Object input) {
        html << input
    }

    void escape(Object input) {
        escape << input
    }

    protected void prepare() {
        StringBuilder stringBuilder = new StringBuilder()
        html = new RawHtmlBuilder(stringBuilder)
        escape = new EscapedHtmlBuilder(stringBuilder)
        js = new JavascriptBuilder()
    }

    public String render() {
        prepare()
        build()
        renderJavascript()
        return format()
    }

    protected String format(){
        String result = html.toString()
        if (style == HtmlStyle.PRETTY) {
            result = HtmlUtils.tidy(result)
        }
        return result
    }

    protected void renderJavascript() {
        if (js.scoped.size() > 0) {
            html <<  '<script>function _$defer(f){if(typeof $ !== \'undefined\'){$(document).ready(f)}else{f()}}</script>' 
            for (List<String> statements : js.scoped) {
                html <<  '<script>' 
                scopePlus()
                html <<  '_$defer(function(){' 
                scopePlus()
                for (String statement : statements) {
                    html <<  statement 
                }
                scopeMinus()
                html <<  '});' 

                scopeMinus()
                html <<  '</script>' 
            }
        }
    }

    public Html withStyle(HtmlStyle style) {
        this.style = style
        return this
    }

    // Generate a <tag attr="value">CONTENT</tag>
    void tag(String tag, Map attrs, Closure body) {

        html << "<${tag}"
        attrs?.each { Object k, Object v ->
            k = k?.toString()
            if (!v) return
            if (v instanceof Closure) {
                html << " $k=\""
                (v as Closure)()
                html << '"'
            } else {
                String escaped = HtmlUtils.escapeHtmlAttribute(v)
                html << " $k=\"$escaped\""
            }
        }
        if (body) {
            html << '>'
        } else {
            html << ' />'
        }

        scopePlus()

        if (body) {
            def bodyOut = body()
            if (bodyOut instanceof String) {
                html << bodyOut
            }
        }

        scopeMinus()

        if (body) {
            html << "</${tag}>"
        }
    }

    // called when going down in the DOM tree
    protected void scopePlus() {
        js.stash()
    }

    // called when going up in the DOM tree
    protected void scopeMinus() {
        js.stash()

    }
}