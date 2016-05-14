package acavailhez.html.bootstrap

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import Bootstrap4Trait
import org.junit.Test

public class BootstrapGridTest extends AbstractTest {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}


    @Test
    public void testNoColumn() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                container {
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<div class="container"></div>')
    }


    @Test
    public void testOneColumn() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                container {
                    colLg12 {
                        escape << "huge column"
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<div class="container"><div class="row"><div class="col-lg-12">huge column</div></div></div>')
    }

    @Test
    public void testOneColumnTooSmall() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                container {
                    colLg10 {
                        escape << "column too small"
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<div class="container"><div class="row"><div class="col-lg-10">column too small</div></div></div>')
    }

    @Test
    public void testThreeColumns() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                container {
                    colMd4 { escape << "one" }
                    colMd4 { escape << "two" }
                    colMd4 { escape << "three" }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
<div class="container">
 <div class="row">
  <div class="col-md-4">one</div>
  <div class="col-md-4">two</div>
  <div class="col-md-4">three</div>
 </div>
</div>''')
    }

    @Test
    public void testTwoRows() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                container {
                    colSm6 { escape << "one" }
                    colSm6 { escape << "two" }
                    colSm6 { escape << "three" }
                    colSm6 { escape << "four" }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
<div class="container">
 <div class="row">
  <div class="col-sm-6">one</div>
  <div class="col-sm-6">two</div>
 </div>
 <div class="row">
  <div class="col-sm-6">three</div>
  <div class="col-sm-6">four</div>
 </div>
</div>''')
    }
}