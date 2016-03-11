import acavailhez.html.Html
import org.junit.Test

public class SimpleTest {

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

}