package acavailhez.html

import org.junit.Test

public class SimpleTest extends AbstractTest {

    @Test
    public void testEmpty() throws Exception {
        assert (new Html() {
            @Override
            public void build() {

            }
        }).render() == ""
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
        }).render()

        assert html == '<div class="class-of-div">INSIDE THE DIV</div>'
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
                }
            }
        }).withStyle(HtmlStyle.PRETTY)
                .render()

        assert renderEquals(html, '''
<div>
 <span>
  <p>embed</p>
 </span>
</div>
''')
    }



}