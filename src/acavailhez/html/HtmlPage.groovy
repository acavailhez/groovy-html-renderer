package acavailhez.html

abstract class HtmlPage extends Html {


    protected void head() {
        // override if you want to add stuff to <head>
    }

    protected abstract String title();

    protected void description() {
        // override if you want to add a <description>
    }

    protected abstract void body();

    @Override
    final protected void build() {
        // Everything is done in render
    }

    @Override
    public String render() {
        prepare()
        StringBuilder rendered = new StringBuilder()
        rendered << '<!DOCTYPE html>' << endLine()
        rendered << '<html>' << endLine()
        scopePlus()
        rendered << getCurrentTabulations() << '<head>' << endLine()
        rendered << getCurrentTabulations() << '<title>' << title() << '</title>'
        scopePlus()
        head()
        scopeMinus()
        rendered << getCurrentTabulations() << '</head>' << endLine()
        rendered << getCurrentTabulations() << '<body>' << endLine()
        scopePlus()
        body()
        rendered << html.toString()
        renderJavascript(rendered)
        scopeMinus()
        rendered << '</body>' << endLine()
        scopeMinus()
        rendered << '</html>'
        return rendered.toString()
    }
}
