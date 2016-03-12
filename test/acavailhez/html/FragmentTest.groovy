package acavailhez.html

import org.junit.Test

public class FragmentTest extends AbstractTest {


    @Test
    public void testJavascript() throws Exception {
        HtmlFragment fragment = (new HtmlFragment() {

            protected void build() {
                div {
                    escape << "text"
                    js << 'var i=0;'
                }
            }

        }).withStyle(HtmlStyle.PRETTY)

        assert renderEquals(fragment.getRawHtml(), '''
  <div>text</div>
''')
        assert renderEquals(fragment.getRawJavascript(),'''
try{var i=0;}catch(e){console.log(e)}''')
    }
}