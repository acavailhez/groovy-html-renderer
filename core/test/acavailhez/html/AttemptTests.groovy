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