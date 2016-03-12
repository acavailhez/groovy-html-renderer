package acavailhez.html


abstract class AbstractTest {
    protected renderEquals(String render, String expect) {
        render = render.replaceAll('\r\n', '\n')
        render = render.replaceAll('\r', '\n')
        expect = expect.replaceAll('\r\n', '\n')
        expect = expect.replaceAll('\r', '\n')
        // trim begin and end endlines
        while (render.charAt(0) == '\n') {
            render = render.substring(1, render.length() - 1)
        }
        while (expect.charAt(0) == '\n') {
            expect = expect.substring(1, expect.length() - 1)
        }
        while (render.charAt(render.length() - 1) == '\n') {
            render = render.substring(0, render.length() - 2)
        }
        while (expect.charAt(expect.length() - 1) == '\n') {
            expect = expect.substring(0, expect.length() - 2)
        }
        return render == expect
    }
}
