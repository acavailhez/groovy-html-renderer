package acavailhez.html.bootstrap

import acavailhez.html.Html
import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class BootstrapNavTests extends AbstractTests {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void tabs() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                tabs {
                    tab("Profile") {
                        p {
                            escape << "Profile text"
                        }
                    }
                    tab("More") {
                        p {
                            escape << "More text"
                        }
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '<ul role="tab-list" class="nav navbar-nav"><li class="nav-item"><a role="tab" data-toggle="tab" href="#profile" class="nav-link">Profile</a></li><li class="nav-item"><a role="tab" data-toggle="tab" href="#more" class="nav-link">More</a></li></ul><div class="tab-content"><div class="tab-pane" id="profile" role="tabpanel"><p>Profile text</p></div><div class="tab-pane" id="more" role="tabpanel"><p>More text</p></div></div>')
    }
}