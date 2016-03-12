package acavailhez.html


abstract class AbstractTest {
    protected renderEquals(String render, String html) {
        render = render.replaceAll('\r\n', '\n')
        render = render.replaceAll('\r', '\n')
        html = html.replaceAll('\r\n', '\n')
        html = html.replaceAll('\r', '\n')
        render = '\n' + render  // this allows to write the expected html in groovy multiline in a nice way

        return render == html
    }
}
