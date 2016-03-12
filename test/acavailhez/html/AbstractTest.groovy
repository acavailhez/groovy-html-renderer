package acavailhez.html


abstract class AbstractTest {
    protected renderEquals(String render, String expect) {
        render = render.replaceAll('\r\n', '')
        render = render.replaceAll('\r', '')
        render = render.replaceAll('\n', '')
        render = render.replaceAll("\\s+", " ")
        render = render.replaceAll("> ", ">")
        render = render.replaceAll(" <", "<")
        expect = expect.replaceAll('\r\n', '')
        expect = expect.replaceAll('\r', '')
        expect = expect.replaceAll('\n', '')
        expect = expect.replaceAll("\\s+", " ")
        expect = expect.replaceAll("> ", ">")
        expect = expect.replaceAll(" <", "<")
        return render == expect
    }
}
