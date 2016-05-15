package acavailhez.html.resources

import acavailhez.html.traits.HeadTrait

trait HtmlResourcesTrait implements HeadTrait {

    void resources(HtmlResourcesPack pack) {
        pack.resources.each { HtmlResource resource ->
            if (resource.url.endsWith('.js')) {
                javascript(resource.url)
            } else if (resource.url.endsWith('.css')) {
                css(resource.url)
            }
        }
    }

}
