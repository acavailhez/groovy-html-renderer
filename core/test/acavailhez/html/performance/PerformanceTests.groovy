package acavailhez.html.performance

import acavailhez.html.tests.AbstractTests
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Logger
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.junit.Before
import org.junit.Test

public class PerformanceTests extends AbstractTests {

    private final static Logger log = Logger.getLogger(PerformanceTests)

    @Before
    public void before() {
        BasicConfigurator.configure()
    }

    @Test
    public void test1000BootstrapModals() throws Exception {

        log.info("preheat")

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        generateModalHtmlWithVelocity(100, ve)
        generateModalHtmlWithGroovyHtmlRenderer(100)

        log.info('run')

        long msVelocity = generateModalHtmlWithVelocity(1000, ve)
        long msGroovy = generateModalHtmlWithGroovyHtmlRenderer(1000)

        log.info('velocity:' + msVelocity + 'ms')
        log.info('groovy-html-renderer:' + msGroovy + 'ms')
    }

    private static long generateModalHtmlWithGroovyHtmlRenderer(int number) {
        return run(number) {
            new ModalHtml("World", "One <>fine body…").getRawHtml()
        }
    }

    private static long generateModalHtmlWithVelocity(int number, VelocityEngine ve) {
        Template t = ve.getTemplate("./test-resources/modal.vm");
        return run(number) {
            VelocityContext context = new VelocityContext();
            context.put("title", "World")
            context.put("closeLabel", "Close")
            context.put("content", "One <>fine body…")
            StringWriter writer = new StringWriter();
            t.merge(context, writer);
            writer.toString()
        }
    }

    @Test
    public void test1000GrailsHomepages() throws Exception {
        log.info("preheat")

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        generateGrailsHomepageWithVelocity(100, ve)
        generateGrailsHomepageWithGroovyHtmlRenderer(100)

        log.info('run')

        long msVelocity = generateGrailsHomepageWithVelocity(1000, ve)
        long msGroovy = generateGrailsHomepageWithGroovyHtmlRenderer(1000)


        log.info('velocity:' + msVelocity + 'ms')
        log.info('groovy-html-renderer:' + msGroovy + 'ms')

    }

    private static long generateGrailsHomepageWithGroovyHtmlRenderer(int number) {
        return run(number) {
            new GrailsHomepage().getRawHtml()
        }
    }

    private static long generateGrailsHomepageWithVelocity(int number, VelocityEngine ve) {
        Template t = ve.getTemplate("./test-resources/grails.vm");
        return run(number) {
            StringWriter writer = new StringWriter();
            t.merge(null, writer);
            writer.toString()
        }
    }

    private static long run(int number, Closure runnable) {
        long ms = System.currentTimeMillis()
        for (int i = 0; i < number; i++) {
            runnable(i)
        }
        return System.currentTimeMillis() - ms
    }

}