package acavailhez.html

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class EscapeTests extends AbstractTests{

    @Test
    public void testNull() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    escape << null
                }
            }
        }).getRawHtml()

        assert html == '<div></div>'
    }

    @Test
    public void testString() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    escape << "Test String" << " String2"
                }
            }
        }).getRawHtml()

        assert html == '<div>Test String String2</div>'
    }

    @Test
    public void testObject() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    escape << [a: "b"]
                }
            }
        }).getRawHtml()

        assert html == '<div>[a:b]</div>'
    }

    @Test
    public void testEscape() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    escape << "a < b => &nbsp;"
                }
            }
        }).getRawHtml()

        assert html == '<div>a &lt; b =&gt; &amp;nbsp;</div>'
    }

}