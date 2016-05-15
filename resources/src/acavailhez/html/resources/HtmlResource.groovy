package acavailhez.html.resources

class HtmlResource {

    private String url
    private HtmlResourceDisposition disposition = HtmlResourceDisposition.HEAD

    public HtmlResource(String url) {
        this.url = url
    }

    public HtmlResource withDisposition(HtmlResourceDisposition disposition) {
        this.disposition = disposition
        return this
    }

    // getters
    public String getUrl() {
        return url
    }

    public HtmlResourceDisposition getDisposition() {
        return disposition
    }
}
