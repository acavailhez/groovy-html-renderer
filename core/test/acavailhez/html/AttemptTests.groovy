package acavailhez.html

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class AttemptTests extends AbstractTests {

    @Test
    public void testSuccess() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    attempt {
                        div {
                            escape << 'text'
                        }
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, "<div><div>text</div></div>")
    }

    @Test
    public void testSuccessWithCatch() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                attempt {
                    div {
                        attempt {
                            div {
                                escape << 'text'
                            }
                        }
                    }
                } { Throwable t ->
                    span {
                        escape << 'failed with:' << t.getMessage()
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, "<div><div>text</div></div>")
    }

    @Test
    public void testError() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    attempt {
                        div {
                            escape << 'text'
                            throw new Exception("oups")
                        }
                    }
                }
            }
        }).getRawHtml()

        assert renderEquals(html, "<div></div>")
    }

    @Test
    public void testErrorDoNotKeepDefers() throws Exception {
        HtmlFragment fragment = (new HtmlFragment() {

            protected void build() {
                div {
                    escape << "text"
                    attempt {
                        defer {
                            div(class: 'modal') {
                                escape << 'deferred'
                            }
                        }
                        div {
                            escape << 'text'
                            throw new Exception("oups")
                        }
                    }
                }
            }

        }).withStyle(HtmlStyle.PRETTY)

        assert renderEquals(fragment.getRawHtml(), '''
  <div>text</div>
''')
        assert renderEquals(fragment.getRawDeferredHtml(), "")
        assert renderEquals(fragment.getRawJavascript(), "")
    }

    @Test
    public void testErrorWithCatch() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    attempt {
                        div {
                            escape << 'text'
                            throw new Exception("oups")
                        }
                    } { Throwable t ->
                        span {
                            escape << 'failed with:' << t.getMessage()
                        }
                    }
                }

            }
        }).getRawHtml()

        assert renderEquals(html, "<div><span>failed with:oups</span></div>")
    }
}