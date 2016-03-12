package acavailhez.html

import org.junit.Test

public class CaptureTest extends AbstractTest {

    @Test
    public void testSuccess() throws Exception {
        String captured
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    captured = capture {
                        span {
                            escape << 'text'
                        }
                    }
                }
            }
        }).getRawHtml()
        assert html == "<div></div>"
        assert captured == "<span>text</span>"
    }
}