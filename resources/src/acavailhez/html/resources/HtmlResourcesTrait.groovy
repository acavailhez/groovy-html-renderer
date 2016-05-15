package acavailhez.html.resources

import acavailhez.html.traits.HeadTrait
import acavailhez.html.traits.HtmlFragmentTrait

trait HtmlResourcesTrait implements HeadTrait, HtmlFragmentTrait {

    void resources(HtmlResourcesPack pack) {

        Closure renderResource = { HtmlResource resource ->
            if (resource.url.endsWith('.js')) {
                javascript(resource.url)
            } else if (resource.url.endsWith('.css')) {
                css(resource.url)
            }
        }

        for (HtmlResource resource : pack.resources) {
            if (resource.disposition == HtmlResourceDisposition.HEAD) {
                renderResource(resource)
            } else {
                defer {
                    renderResource(resource)
                }
            }
        }
    }

}
