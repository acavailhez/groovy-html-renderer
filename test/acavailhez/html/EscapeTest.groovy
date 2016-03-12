package acavailhez.html

import acavailhez.html.Html
import acavailhez.html.HtmlStyle
import org.junit.Test

public class EscapeTest extends AbstractTest{

    @Test
    public void testNull() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    escape << null
                }
            }
        }).render()

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
        }).render()

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
        }).render()

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
        }).render()

        assert html == '<div>a &lt; b =&gt; &amp;nbsp;</div>'
    }

}