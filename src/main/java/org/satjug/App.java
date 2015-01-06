package org.satjug;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class App {
    public static void main(String[] args) {
        new App().main();
    }

    final Server server;
    public App() {
        server = new Server();
    }

    public void main() {
        //Start up a jetty and do something with it
    }

    public int getPort() {
        return ((ServerConnector)server.getConnectors()[0]).getLocalPort();
    }
}
