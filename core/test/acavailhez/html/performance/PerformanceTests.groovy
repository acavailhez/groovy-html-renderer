package acavailhez.html.performance

import acavailhez.html.Html
import acavailhez.html.HtmlStyle
import acavailhez.html.tests.AbstractTests
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.junit.Test

public class PerformanceTests extends AbstractTests {

    class PerfHtml extends Html {

        private final String hello

        public PerfHtml(String hello) {
            this.hello = hello
        }

        @Override
        protected void build() {
            div(class: 'box') {
                div(class: 'box-body') {
                    escape << "Hello " + hello
                }
            }
        }
    }

    @Test
    public void test1000() throws Exception {

        long ms, diff

        // html-groovy-renderer
        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new PerfHtml("World").withStyle(HtmlStyle.PRETTY).getRawHtml()
        }
        diff = System.currentTimeMillis() - ms
        println 'Simple style HTML 1000:' + diff + 'ms'

        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new PerfHtml("World").getRawHtml()
        }
        diff = System.currentTimeMillis() - ms
        println 'Simple HTML 1000:' + diff + 'ms'

        // velocity
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            Template t = ve.getTemplate("./test-resources/simple.vm");
            VelocityContext context = new VelocityContext();
            context.put("hello", "World")
            StringWriter writer = new StringWriter();
            t.merge(context, writer);
            writer.toString()
        }
        diff = System.currentTimeMillis() - ms
        println 'Velocity Simple HTML 1000:' + diff + 'ms'

    }

    @Test
    public void test1000Modals() throws Exception {

        long ms, diff

        // html-groovy-renderer
        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new ModalHtml("World", "One fine body…").withStyle(HtmlStyle.PRETTY).getRawHtml()
        }
        diff = System.currentTimeMillis() - ms
        println 'Simple style HTML 1000:' + diff + 'ms'

        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new ModalHtml("World", "One fine body…").getRawHtml()
        }
        diff = System.currentTimeMillis() - ms
        println 'Simple HTML 1000:' + diff + 'ms'

        // velocity
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            Template t = ve.getTemplate("./test-resources/modal.vm");
            VelocityContext context = new VelocityContext();
            context.put("title", "World")
            context.put("content", "One fine body…")
            StringWriter writer = new StringWriter();
            t.merge(context, writer);
            writer.toString()
        }
        diff = System.currentTimeMillis() - ms
        println 'Velocity Simple HTML 1000:' + diff + 'ms'
    }

    @Test
    public void test1000Pages() throws Exception {
        println 'preheat'
        for (int i = 0; i < 100; i++) {
            new GrailsFrontPage().getRawHtml()
        }

        println 'go'
        long ms = System.currentTimeMillis()
        for (int i = 0; i < 1000; i++) {
            new GrailsFrontPage().getRawHtml()
        }
        long diff = System.currentTimeMillis() - ms
        println 'Simple HTML 1000:' + diff + 'ms'

    }
}