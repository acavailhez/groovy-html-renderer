package acavailhez.html

import org.junit.Test

public class PageTest extends AbstractTest {


    @Test
    public void testMinimal() throws Exception {
        String html = (new HtmlPage() {

            @Override
            protected String title() {
                return 'Page'
            }

            @Override
            protected void body() {
                div{
                    escape << "text"
                }
            }

        }).withStyle(HtmlStyle.PRETTY).render()

        assert renderEquals(html, '''
<!DOCTYPE html>
<html>
 <head>
 <title>Page</title> </head>
 <body>
  <div>text</div>
 </body>
</html>
''')
    }
}