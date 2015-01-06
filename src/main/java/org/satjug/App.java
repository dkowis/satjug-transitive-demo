package org.satjug;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class App {
    public static void main(String[] args) throws Exception {
        new App().main();
    }

    final Server server;
    public App() {
        server = new Server();
    }

    public void main() throws Exception {
        //Start up a jetty and do something with it
        server.start();
    }

    public int getPort() {
        return ((ServerConnector)server.getConnectors()[0]).getLocalPort();
    }
}
