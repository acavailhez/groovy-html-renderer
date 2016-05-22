package acavailhez.html.bootstrap

import acavailhez.html.Html
import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class BootstrapButtonTests extends AbstractTests {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void testSimple() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn([:]), "Click me")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-default" type="button">Click me</a>')
    }

    @Test
    public void testBody() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                button(btn(id: 'abc')) {
                    escape << 'Click ' + ' me'
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<button id="abc" class="btn btn-default" type="button">Click me</button>')
    }

    @Test
    public void testColor() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(color: Bootstrap4Color.DANGER), "Do the thing")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-danger" type="button">Do the thing</a>')
    }

    @Test
    public void testColorString() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(color: 'danger'), "Do the thing")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-danger" type="button">Do the thing</a>')
    }

    @Test
    public void testButtonWrongColor() throws Exception {

        try {
            String html = (new BootstrapHtml() {
                @Override
                public void build() {
                    a(btn(color: 'danger2'), "Do the thing")
                }
            }).getRawHtml()

            throw new RuntimeException("Should have crashed")
        }
        catch (IllegalArgumentException ex) {
            // we're good
        }
    }

    @Test
    public void testButtonSize() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(color: Bootstrap4Color.DANGER, size: Bootstrap4Size.LG), "Do the thing")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-danger btn-lg" type="button">Do the thing</a>')
    }

    @Test
    public void testOutline() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(color: Bootstrap4Color.DANGER, outline: true, size: Bootstrap4Size.LG), "Do the thing")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-danger-outline btn-lg" type="button">Do the thing</a>')
    }

    @Test
    public void testAddClass() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(class: 'my-button-class'), "Click me")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="my-button-class btn btn-default" type="button">Click me</a>')
    }
}