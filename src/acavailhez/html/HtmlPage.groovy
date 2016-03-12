package acavailhez.html

import acavailhez.html.traits.HeadTrait

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
        return '<meta name="viewport" content="width=device-width, initial-scale=1.0">'
    }

    protected String favicon() {
        // override if you want to change the favicon
        return null
    }

    protected abstract void body();

    @Override
    final protected void build() {
        html << '<!doctype html>'
        tag('html', [:]) {
            tag('head', [:]) {
                html << '<meta charset="utf-8">'
                html << '<title>' << title() << '</title>'
                String description = description()
                if (description != null && !description.isEmpty()) {
                    html << '<meta name="description" content="' << HtmlUtils.escapeTextToHtml(description) << '">'
                }
                String viewport = viewport()
                if (viewport != null && !viewport.isEmpty()) {
                    html << viewport
                }
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
                html << deferHtmlBuilder.toRawHtml()
                js.renderForHtml(html)
            }
        }
    }
}
