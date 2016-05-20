package acavailhez.html

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class FragmentTests extends AbstractTests {


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
        assert renderEquals(fragment.getRawJavascript(), '''
try{var i=0;}catch(e){console.log(e)}''')
    }

    @Test
    public void testDeferHtml() throws Exception {
        HtmlFragment fragment = (new HtmlFragment() {

            protected void build() {
                div {
                    escape << "text"
                    defer {
                        div(class: 'modal') {
                            escape << 'deferred'
                        }
                    }
                }
            }

        }).withStyle(HtmlStyle.PRETTY)

        assert renderEquals(fragment.getRawHtml(), '''
  <div>text</div>
''')
        assert renderEquals(fragment.getRawDeferredHtml(), '''
<div class="modal">deferred</div>''')
    }

    @Test
    public void testInsert() throws Exception {
        HtmlFragment fragment = (new HtmlFragment() {

            protected void build() {
                div {
                    insert(new HtmlFragment() {
                        @Override
                        protected void build() {
                            div {
                                escape << "fragment"
                            }
                            defer {
                                div(class: 'modal') {
                                    escape << 'deferred'
                                }
                            }
                        }
                    }, HtmlRenderMode.IMMEDIATE)
                    escape << "text"
                }
            }

        }).withStyle(HtmlStyle.PRETTY)

        assert renderEquals(fragment.getRawHtml(), '''
  <div>
    <div>
      fragment
  </div>text
  </div>
''')
        assert renderEquals(fragment.getRawDeferredHtml(), '''
<div class="modal">deferred</div>''')
    }
}