package acavailhez.html


abstract class AbstractTest {

    protected boolean contains(String render, String find, Map options = [:]) {
        render = canonize(render)
        find = canonize(find)
        if (!render.contains(find)) {
            println('render: ' + render)
            println('contains: ' + find)
            return false
        }
        return true
    }

    protected boolean renderEquals(String render, String expect) {
        render = canonize(render)
        expect = canonize(expect)
        if (render != expect) {
            println('render: ' + render)
            println('expect: ' + expect)
            return false
        }
        return true
    }

    private static String canonize(String html) {
        return html.replaceAll('\r\n', '')
                .replaceAll('\r', '')
                .replaceAll('\n', '')
                .replaceAll("\\s+", " ")
                .replaceAll("> ", ">")
                .replaceAll(" <", "<")
    }
}
