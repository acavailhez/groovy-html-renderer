package acavailhez.html.resources

import acavailhez.html.AbstractTest
import acavailhez.html.HtmlPage
import org.junit.Test

class SimpleTests extends AbstractTest {

    static abstract class ResourcesPage extends HtmlPage implements HtmlResourcesTrait {
        @Override
        protected String title() {
            return "Resources page"
        }
    }

    @Test
    public void absoluteResources() throws Exception {
        HtmlResourcesPack pack = new HtmlResourcesPack()
        pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css')
        pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js')

        String html = (new ResourcesPage() {

            @Override
            protected void head() {
                resources(pack)
            }

            public void body() {
            }
        }).getRawHtml()

        assert contains(html, '''
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
''')
        assert contains(html, '''
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js">
''')
    }
}