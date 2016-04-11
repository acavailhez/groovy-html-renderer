package acavailhez.html.bootstrap

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import acavailhez.html.traits.bootstrap.Bootstrap4ButtonStyle
import acavailhez.html.traits.bootstrap.Bootstrap4Trait
import org.junit.Test

public class BootstrapButtonTest extends AbstractTest {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void testSimple() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapButton([:], "Click me")
            }
        }).getRawHtml()

        assert renderEquals(html, '<button class="btn btn-default" type="button">Click me</button>')
    }

    @Test
    public void testBody() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapButton(id: 'abc') {
                    escape << 'Click ' + ' me'
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<button class="btn btn-default" id="abc" type="button">Click me</button>')
    }

    @Test
    public void testStyle() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapButton("Do the thing", btnStyle: Bootstrap4ButtonStyle.DANGER)
            }
        }).getRawHtml()

        assert renderEquals(html, '<button class="btn btn-danger" type="button">Do the thing</button>')
    }

    @Test
    public void testStyleString() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapButton("Do the thing", btnStyle: 'danger')
            }
        }).getRawHtml()

        assert renderEquals(html, '<button class="btn btn-danger" type="button">Do the thing</button>')
    }

    @Test
    public void testButtonWrongStyle() throws Exception {

        try {
            String html = (new BootstrapHtml() {
                @Override
                public void build() {
                    bootstrapButton("Do the thing", btnStyle: 'danger2')
                }
            }).getRawHtml()

            throw new RuntimeException("Should have crashed")
        }
        catch (IllegalArgumentException ex) {
            // we're good
        }
    }

    @Test
    public void testAddClass() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapButton("Click me", class: 'my-button-class')
            }
        }).getRawHtml()

        assert renderEquals(html, '<button class="my-button-class btn btn-default" type="button">Click me</button>')
    }
}