package acavailhez.html

import org.junit.Test

public class AttemptTest extends AbstractTest {

    @Test
    public void testSuccess() throws Exception {
        assert (new Html() {
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
        }).getRawHtml() == "<div><div>text</div></div>"
    }

    @Test
    public void testSuccessWithCatch() throws Exception {
        assert (new Html() {
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
        }).getRawHtml() == "<div><div>text</div></div>"
    }

    @Test
    public void testError() throws Exception {
        assert (new Html() {
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
        }).getRawHtml() == "<div></div>"
    }

    @Test
    public void testErrorWithCatch() throws Exception {
        assert (new Html() {
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
        }).getRawHtml() == "<div><span>failed with:oups</span></div>"
    }
}