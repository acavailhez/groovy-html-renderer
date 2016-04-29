package acavailhez.html.bootstrap

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import acavailhez.html.traits.bootstrap.Bootstrap4Color
import acavailhez.html.traits.bootstrap.Bootstrap4Trait
import org.junit.Test

public class BootstrapModalTest extends AbstractTest {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void testEmpty() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                modal([:]) {

                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
 <div class="modal fade" role="dialog" tabindex="-1">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button class="close" data-dismiss="modal" type="button">
      <span aria-hidden="true">&times;</span>
     </button>
    </div>
    <div class="modal-body">
    </div>
   </div>
  </div>
 </div>
''')
    }

    @Test
    public void testTitle() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                modal([title: 'A nice title', tabindex: 2, id:'my-modal']) {

                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
 <div class="modal fade" id="my-modal" role="dialog" tabindex="2">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button class="close" data-dismiss="modal" type="button">
      <span aria-hidden="true">&times;</span>
     </button>
     <h4 class="modal-title">A nice title</h4>
    </div>
    <div class="modal-body">
    </div>
   </div>
  </div>
 </div>
''')
    }

    @Test
    public void testBootstrapExample() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                modal(title: "Modal title", closeLabel: "Close") {
                    p("One fine body…")
                } {
                    button(btn('data-dismiss': 'modal'), "Close")
                    button(btn(color: Bootstrap4Color.PRIMARY), "Save changes")
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
<div class="modal fade" role="dialog" tabindex="-1">
 <div class="modal-dialog">
   <div class="modal-content">
     <div class="modal-header">
       <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span aria-hidden="true">&times;</span></button>
       <h4 class="modal-title">Modal title</h4>
     </div>
     <div class="modal-body">
       <p>One fine body&hellip;</p>
     </div>
     <div class="modal-footer">
       <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
       <button class="btn btn-primary" type="button">Save changes</button>
     </div>
   </div>
 </div>
</div>
''')
    }

    @Test
    public void testModalA() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                a(btn(modal(color:Bootstrap4Color.PRIMARY, modal:'my-modal')),"Open modal")
            }
        }).getRawHtml()

        assert renderEquals(html, '<a class="btn btn-primary" data-target="#my-modal" data-toggle="modal" type="button">Open modal</a>')
    }
}