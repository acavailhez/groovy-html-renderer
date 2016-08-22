package acavailhez.html.spark;

import acavailhez.html.HtmlPage;
import org.apache.log4j.Logger;
import spark.Request;
import spark.Response;

public class HtmlPageSparkRoute extends AbstractSparkRoute {

    private static final Logger log = Logger.getLogger(HtmlPageSparkRoute.class);

    private final Class<? extends HtmlPage> htmlPageClass;

    public HtmlPageSparkRoute(Class<? extends HtmlPage> htmlPageClass) {
        this.htmlPageClass = htmlPageClass;
    }

    @Override
    protected Object route(Request request, Response response) throws Exception {
        return page(htmlPageClass.getConstructor().newInstance());
    }
}
