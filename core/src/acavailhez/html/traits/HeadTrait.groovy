package acavailhez.html.traits

trait HeadTrait extends HtmlTrait {
    abstract void tag(String tag, Map attrs, Closure body)

    void meta(Map attrs) {
        tag('meta', attrs, null)
    }

    void css(String url) {
        tag('link', [href: url, rel: "stylesheet", type: "text/css"], null)
    }

    void javascript(String url) {
        tag('script', [src: url], {
            html ' '
        })
    }
}


