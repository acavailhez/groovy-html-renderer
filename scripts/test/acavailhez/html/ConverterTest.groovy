import org.junit.Test

public class ConverterTest {

    @Test
    public void testInline() throws Exception {
        String groovy = HtmlToGroovyConverter.convertHtmlStringToGroovyCode('''
<div class="box">
     content of the <strong>box</strong> inside
</div>
''')
        assert syntaxEquals(groovy, '''
div(class:'box'){
    escape << "content of the"
    strong{
     escape << "box"
    }
    escape << "inside"
}
''')
    }

    @Test
    public void testSimple() throws Exception {
        String groovy = HtmlToGroovyConverter.convertHtmlStringToGroovyCode('''
<div class="box">
  <div modal-attribute="box-body">
     content of the box
  </div>
</div>
''')
        assert syntaxEquals(groovy, '''
div(class:'box'){
  div('modal-attribute':'box-body'){
    escape << "content of the box"
  }
}
''')
    }

    @Test
    public void testInlineTag() throws Exception {
        String groovy = HtmlToGroovyConverter.convertHtmlStringToGroovyCode('''
<img src="http://i.imgur.com/DIv298y.jpg">
''')
        assert syntaxEquals(groovy, '''
img(src:'http://i.imgur.com/DIv298y.jpg')
''')
    }

    @Test
    public void convertFromUrl() throws Exception {
        String groovy = HtmlToGroovyConverter.convertHtmlUrlToGroovyCode('https://grails.org')
        println groovy
    }

    protected syntaxEquals(String render, String expect) {
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
        if (render != expect) {
            println('render: ' + render)
            println('expect: ' + expect)
        }
        return render == expect
    }
}