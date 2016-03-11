package acavailhez.html

import org.junit.Test

public class HtmlUtilsTest {

    @Test
    public void simple() throws Exception {
        assert HtmlUtils.escapeHtmlAttribute(null) == ""
        assert HtmlUtils.escapeHtmlAttribute("abc") == "abc"
        assert HtmlUtils.escapeHtmlAttribute('ab"c') == 'ab&quot;c'
    }


}