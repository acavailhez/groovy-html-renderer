package acavailhez.html

import acavailhez.html.traits.HeadTrait

abstract class HtmlPage extends Html implements HeadTrait {


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
        // Everything is done in render
    }

    @Override
    public String render() {
        prepare()
        html << '<!doctype html>' << endLine()
        tag('html', [:]) {
            tag('head', [:]) {
                html << tabulate() << '<meta charset="utf-8">' << endLine()
                html << tabulate() << '<title>' << title() << '</title>' << endLine()
                String description = description()
                if (description != null && !description.isEmpty()) {
                    html << tabulate() << '<meta name="description" content="' << HtmlUtils.escapeTextToHtml(description) << '">' << endLine()
                }
                String viewport = viewport()
                if (viewport != null && !viewport.isEmpty()) {
                    html << tabulate() << viewport << endLine()
                }
                String favicon = favicon()
                if (favicon != null && !favicon.isEmpty()) {
                    String type = "image/x-icon"
                    if (favicon.endsWith('.png')) {
                        type = "image/png"
                    }
                    html << tabulate() << '<link rel="icon" href="' << favicon << '" type="' << type << '">'
                }
                head()
            }
            tag('body', [:]) {
                body()
                renderJavascript()
            }
        }
        return format()
    }
}
