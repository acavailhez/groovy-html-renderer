package acavailhez.html.resources

import acavailhez.html.HtmlPage
import acavailhez.html.HtmlStyle
import acavailhez.html.tests.AbstractTests
import org.junit.Test

class SimpleTests extends AbstractTests {

    static abstract class ResourcesPage extends HtmlPage implements HtmlResourcesTrait {
        @Override
        protected String title() {
            return "Resources page"
        }
    }

    @Test
    public void pack() throws Exception {
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

    @Test
    public void disposition() throws Exception {
        HtmlResourcesPack pack = new HtmlResourcesPack()
        pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css')
        pack.add('https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js').withDisposition(HtmlResourceDisposition.FOOT)

        String html = (new ResourcesPage() {

            @Override
            protected void head() {
                resources(pack)
            }

            public void body() {
                div {
                    escape << "text"
                }
            }
        }).withStyle(HtmlStyle.PRETTY).getRawHtml()

        assert contains(html, '''
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
''', [before:'</head>'])
        assert contains(html, '''
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js">
''',[after:'</div>',before:'</body>'])
    }
}
