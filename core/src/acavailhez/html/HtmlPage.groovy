package acavailhez.html

import acavailhez.html.traits.HeadTrait
import acavailhez.html.utils.HtmlUtils

// Renders a full html page
// To configure, override the functions:
//
// title() - will specify the <title> of the page
// description() - will specify the <meta name="description" content="XX">
// viewport() - will reconfigure the <meta name="viewport" content="XX">
// favicon() - will reconfigure the favicon url (the type will depend on the file extension)
// head() - will append more to the <head>
//
abstract class HtmlPage extends HtmlFragment implements HeadTrait {


    protected void head() {
        // override if you want to add stuff to <head>
    }

    protected abstract String title();

    protected String description() {
        // override if you want to add a <description>
        return null
    }

    protected String viewport() {
        // override if you want to change the viewport
        return 'width=device-width, initial-scale=1, shrink-to-fit=no'
    }

    protected String favicon() {
        // override if you want to change the favicon
        return null
    }

    protected abstract void body();

    @Override
    final protected void build() {
        html << '<!doctype html>'
        html {
            head {
                html << '<meta charset="utf-8">'
                html << '<title>' << title() << '</title>'
                String description = description()
                if (description != null && !description.isEmpty()) {
                    html << '<meta name="description" content="' << HtmlUtils.escapeTextToHtml(description) << '">'
                }
                String viewport = viewport()
                if (viewport != null && !viewport.isEmpty()) {
                    html << '<meta name="viewport" content="' + viewport + '">'
                }
                // Force Internet Explorer to use its latest rendering mode (http://stackoverflow.com/questions/6771258/whats-the-difference-if-meta-http-equiv-x-ua-compatible-content-ie-edge-e)
                html << '<meta http-equiv="x-ua-compatible" content="ie=edge">'
                String favicon = favicon()
                if (favicon != null && !favicon.isEmpty()) {
                    String type = "image/x-icon"
                    if (favicon.endsWith('.png')) {
                        type = "image/png"
                    }
                    html << '<link rel="icon" href="' << favicon << '" type="' << type << '">'
                }
                head()
            }
            tag('body', [:]) {
                body()
                html << getRawDeferredHtml()
                js.renderForHtml(html)
            }
        }
    }
}
