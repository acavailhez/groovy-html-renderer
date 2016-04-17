package acavailhez.html.demo

import org.eclipse.jetty.server.Server

class JettyDemo {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        server.setHandler(new HtmlPageHandler(new Frontpage()))

        server.start();
        server.dumpStdErr();
        server.join();
    }
}
