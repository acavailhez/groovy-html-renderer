package acavailhez.html

import org.junit.Test

public class ShortcutTest extends AbstractTest {

    @Test
    public void testDdt() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dl {
                    ddt("Title") {
                        escape << "content"
                    }
                    ddt("Title2") {
                        escape << "content2"
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
<dl>
 <dt>Title</dt>
 <dd>content</dd>
  <dt>Title2</dt>
 <dd>content2</dd>
</dl>
''')
    }


}