package acavailhez.html

import org.junit.Test

public class HtmlUtilsTest extends AbstractTest {

    @Test
    public void simple() throws Exception {
        assert HtmlUtils.escapeHtmlAttribute(null) == ""
        assert HtmlUtils.escapeHtmlAttribute("abc") == "abc"
        assert HtmlUtils.escapeHtmlAttribute('ab"c') == 'ab&quot;c'
    }

    @Test
    public void tidy() throws Exception {
        assert renderEquals(HtmlUtils.tidy('<div> test</div >'), '<div>test</div>')
        assert renderEquals(HtmlUtils.tidy('<img src="test">'), '<img src="test">')
    }


    @Test
    public void testOptAttr() throws Exception {

        assert HtmlUtils.optAttribute(null, 'test', String, null) == null
        assert HtmlUtils.optAttribute([:], 'test', String, null) == null
        assert HtmlUtils.optAttribute(['a': 1], 'test', String, null) == null

        assert HtmlUtils.optAttribute(null, 'test', String, 'test') == 'test'
        assert HtmlUtils.optAttribute([:], 'test', String, 'test') == 'test'
        assert HtmlUtils.optAttribute(['a': 1], 'test', String, 'test') == 'test'

        assert HtmlUtils.optAttribute(['test': 'test2'], 'test', String, 'test') == 'test2'

        assert HtmlUtils.optAttribute(['test2': 1], 'test', Integer, 2) == 2
        assert HtmlUtils.optAttribute(['test': 1], 'test', Integer, 2) == 1
    }
}