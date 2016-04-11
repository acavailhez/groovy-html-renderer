package acavailhez.html.demo

import org.eclipse.jetty.server.Server

class JettyDemo {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.start();
        server.dumpStdErr();
        server.join();
    }
}
