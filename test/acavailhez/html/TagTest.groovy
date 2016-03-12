package acavailhez.html

import org.junit.Test

public class TagTest extends AbstractTest {

    @Test
    public void testEscapeAttribute() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(attribute: 'value value; value-value| value"value') {
                    escape << 'INSIDE THE DIV'
                }
            }
        }).render()

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
        }).render()

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
        }).render()

        assert html == '<div attr1="one" attr2="two" attr-three="three">INSIDE THE DIV</div>'
    }
}