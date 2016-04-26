package acavailhez.html.bootstrap

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import acavailhez.html.traits.bootstrap.Bootstrap4Color
import acavailhez.html.traits.bootstrap.Bootstrap4Trait
import org.junit.Test

public class BootstrapAlertTest extends AbstractTest {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void testInfo() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                alert(color:Bootstrap4Color.SUCCESS) {
                    escape << "Yeah"
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<div class="alert alert-success" role="alert">Yeah</div>')
    }
}