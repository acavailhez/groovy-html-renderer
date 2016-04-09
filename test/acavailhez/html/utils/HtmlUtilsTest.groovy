package acavailhez.html.utils

import acavailhez.html.AbstractTest
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
}