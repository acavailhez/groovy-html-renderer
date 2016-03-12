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
    private boolean firstLine = true;
    private int currentTabulations = 0;

    protected abstract void build();

    protected void prepare(){
        StringBuilder stringBuilder = new StringBuilder()
        html = new RawHtmlBuilder(stringBuilder)
        escape = new EscapedHtmlBuilder(stringBuilder)
        js = new JavascriptBuilder()
    }

    public String render() {
        prepare()
        build()
        StringBuilder rendered = new StringBuilder()
        rendered << html.toString()
        renderJavascript(rendered)
        return rendered.toString()
    }

    protected void renderJavascript(StringBuilder rendered) {
        if (js.scoped.size() > 0) {
            rendered << '<script>function _$defer(f){if($){$(document).ready(f)}else{f()}};</script>' << endLine()
            for (List<String> statements : js.scoped) {
                rendered << '<script>' << endLine()
                rendered << ' _$defer(function(){' << endLine()
                for (String statement : statements) {
                    rendered << '  ' << statement << endLine()
                }
                rendered << ' }' << endLine()
                rendered << '</script>' << endLine()
            }
        }
    }

    public Html withStyle(HtmlStyle style) {
        this.style = style
        return this
    }

    // Generate a <tag attr="value">CONTENT</tag>
    void tag(String tag, Map attrs, Closure body) {

        if (!firstLine) {
            html << endLine()
        } else {
            firstLine = false
        }
        html << getCurrentTabulations()

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
            html << '/>'
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
            html << endLine()
            html << getCurrentTabulations(-1)
        }
    }

    // called when going down in the DOM tree
    protected void scopePlus() {
        currentTabulations++
        js.stash()
    }

    // called when going up in the DOM tree
    protected void scopeMinus() {
        currentTabulations--
        js.stash()

    }

    protected String endLine() {
        if (style == HtmlStyle.PRETTY) {
            return System.lineSeparator()
        }
        return ''
    }

    protected String getCurrentTabulations(int modifier = 0) {
        if (style == HtmlStyle.PRETTY) {
            int i = currentTabulations + modifier
            StringBuilder sb = new StringBuilder()
            while (i-- > 0) {
                sb.append(' ')
            }
            return sb.toString()
        }
        return ''
    }
}