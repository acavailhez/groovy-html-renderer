package acavailhez.html

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class PageTests extends AbstractTests {


    @Test
    public void testMinimal() throws Exception {
        String html = (new HtmlPage() {

            protected String title() {
                return 'Page'
            }

            protected void body() {
                div {
                    escape << "text"
                }
            }

        }).withStyle(HtmlStyle.PRETTY).getRawHtml()

        assert renderEquals(html, '''
<!doctype html>
<html>
 <head>
  <meta charset="utf-8">
  <title>Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
 </head>
 <body>
  <div>text</div>
 </body>
</html>
''')
    }

    @Test
    public void testWithHeadOptions() throws Exception {
        String html = (new HtmlPage() {

            protected String description() {
                return 'Page about "interesting" things'
            }

            protected String favicon() {
                return '/favicon.png'
            }


            protected String viewport() {
                return null // remove viewport
            }

            protected String title() {
                return 'Page'
            }

            protected void head() {
                meta(property: "og:type", content: "website")
                css('https://cdn.com/min.css')
                javascript('https://cdn.com/min.js')
            }

            protected void body() {
                div {
                    escape << "text"
                }
            }

        }).getRawHtml()

        assert renderEquals(html, '''
<!doctype html>
<html>
 <head>  <meta charset="utf-8">
  <title>Page</title>
  <meta name="description" content="Page about &quot;interesting&quot; things">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link rel="icon" href="/favicon.png" type="image/png">
  <meta property="og:type" content="website">
  <link href="https://cdn.com/min.css" rel="stylesheet" type="text/css">
  <script src="https://cdn.com/min.js"></script>
 </head>
 <body>
  <div>text</div>
 </body>
</html>
''')
    }

    @Test
    public void testJavascript() throws Exception {
        String html = (new HtmlPage() {

            protected String title() {
                return 'Page'
            }

            protected void body() {
                div {
                    escape << "text"
                    js << 'var i=0;'
                }
            }

        }).withStyle(HtmlStyle.PRETTY).getRawHtml()

        assert renderEquals(html, '''
<!doctype html>
<html>
 <head>
  <meta charset="utf-8">
  <title>Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
 </head>
 <body>
  <div>text</div>
  <script>
   var i=0;
  </script>
 </body>
</html>
''')
    }
}