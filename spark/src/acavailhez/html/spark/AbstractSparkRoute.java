package acavailhez.html.spark;

import acavailhez.html.HtmlPage;
import org.apache.log4j.Logger;
import spark.Request;
import spark.Response;
import spark.Route;

public abstract class AbstractSparkRoute implements Route {

    private static final Logger log = Logger.getLogger(AbstractSparkRoute.class);

    protected abstract Object route(Request request, Response response) throws Exception;

    @Override
    final public Object handle(Request request, Response response) throws Exception {
        try {
            return route(request, response);
        } catch (Exception t) {
            log.error("Could not handle route:" + request.uri(), t);
            return onError(t);
        }
    }

    protected Object onError(Exception t) throws Exception {
        // Override if needed
        throw t;
    }

    protected static String page(HtmlPage page) {
        return page.getRawHtml();
    }


}
