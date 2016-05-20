package acavailhez.html

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class TagTests extends AbstractTests {

    @Test
    public void testEscapeAttribute() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(attribute: 'value value; value-value| value"value') {
                    escape << 'INSIDE THE DIV'
                }
            }
        }).getRawHtml()

        assert html == '<div attribute="value value; value-value| value&quot;value">INSIDE THE DIV</div>'
    }

    @Test
    public void testNullAttribute() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(attribute: null) {
                    escape << 'INSIDE THE DIV'
                }
            }
        }).getRawHtml()

        assert html == '<div>INSIDE THE DIV</div>'
    }


    @Test
    public void testSeveralAttributes() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(attr1: "one", attr2: "two", 'attr-three': "three") {
                    escape << 'INSIDE THE DIV'
                }
            }
        }).getRawHtml()

        assert html == '<div attr-three="three" attr1="one" attr2="two">INSIDE THE DIV</div>'
    }
}