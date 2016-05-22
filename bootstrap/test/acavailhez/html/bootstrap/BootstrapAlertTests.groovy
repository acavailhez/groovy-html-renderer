package acavailhez.html.bootstrap

import acavailhez.html.Html
import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class BootstrapAlertTests extends AbstractTests {

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

        assert renderEquals(html, '<div role="alert" class="alert alert-success">Yeah</div>')
    }
}