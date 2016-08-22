import acavailhez.html.demo.Frontpage

import acavailhez.html.spark.HtmlPageSparkRoute
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Level
import org.apache.log4j.Logger

import static spark.Spark.get
import static spark.Spark.port
import static spark.Spark.staticFileLocation

class Main {

    public static void main(String[] args) {

        BasicConfigurator.configure();

        Logger.getLogger("org.eclipse.jetty").setLevel(Level.INFO);
        Logger.getLogger("spark").setLevel(Level.INFO);
        Logger.getLogger("org.apache.http").setLevel(Level.INFO);
        Logger.getLogger("com.brsanthu.googleanalytics").setLevel(Level.INFO);

        port(8080);
        staticFileLocation("/web");

        get("/", new HtmlPageSparkRoute(Frontpage));
    }
}
