package acavailhez.html

import org.junit.Test

public class SimpleTest extends AbstractTest {

    @Test
    public void testEmpty() throws Exception {
        assert (new Html() {
            @Override
            public void build() {

            }
        }).getRawHtml() == ""
    }

    @Test
    public void testEmptyTag() throws Exception {
        assert (new Html() {
            @Override
            public void build() {
                tag('br', [:], null)
            }
        }).getRawHtml() == "<br>"
    }

    @Test
    public void testDiv() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(class: 'class-of-div') {
                    escape << 'INSIDE THE DIV'
                }
            }
        }).getRawHtml()

        assert html == '<div class="class-of-div">INSIDE THE DIV</div>'
    }

    @Test
    public void testLevel() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(attr: "outter") {
                    div(attr: "inner") {
                        escape << 'embed'
                    }
                }
            }
        }).getRawHtml()

        assert html == '<div attr="outter"><div attr="inner">embed</div></div>'
    }

    @Test
    public void testForgotStream() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    'embed'
                }
            }
        }).getRawHtml()

        assert html == '<div></div>'
    }

    @Test
    public void testPretty() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    span {
                        p {
                            escape << 'embed'
                        }
                    }
                    span {
                        escape << 'embed '
                        escape << 'several'
                    }
                }
            }
        }).withStyle(HtmlStyle.PRETTY)
                .getRawHtml()

        assert renderEquals(html, '''
<div>
 <span>
  <p>embed</p>
 </span>
 <span>embed several</span>
</div>
''')
    }


}