package acavailhez.html.performance

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import org.junit.Test

public class PerformanceTest extends AbstractTest {

    class PerfHtml extends Html {

        @Override
        protected void build() {
            div(class: 'box') {
                div(class: 'box-body') {
                    escape << "content of the box"
                }
            }
        }
    }

    @Test
    public void test1000() throws Exception {
        long ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new PerfHtml().getRawHtml()
        }
        long diff = System.currentTimeMillis() - ms
        println 'Simple HTML 1000:' + diff + 'ms'
        // allow less than a ms to render this
        assert diff < 10000
    }

    @Test
    public void test1000Pages() throws Exception {
        long ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new GrailsFrontPage().getRawHtml()
        }
        long diff = System.currentTimeMillis() - ms
        println 'Simple HTML 1000:' + diff + 'ms'
        // allow less than a ms to render this
        assert diff < 10000
    }
}