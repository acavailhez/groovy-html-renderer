package acavailhez.html.resources


class HtmlResourcesPack {

    private final List<HtmlResource> resources = [];

    public HtmlResource add(String url) {
        return add(new HtmlResource(url));
    }

    public HtmlResource add(HtmlResource resource) {
        resources.add(resource);
        return resource;
    }

    public List<HtmlResource> getResources() {
        return Collections.unmodifiableList(resources);
    }


}
