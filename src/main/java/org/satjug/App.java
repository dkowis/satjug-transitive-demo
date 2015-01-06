package org.satjug;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

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
        ServerConnector http = new ServerConnector(server);
        http.setHost("localhost");
        http.setIdleTimeout(30000);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(false);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setBaseResource(Resource.newClassPathResource("/"));

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, new DefaultHandler()});
        server.setHandler(handlers);

        server.addConnector(http);
        server.start();
    }

    public boolean isUp() {
        return server.isStarted();
    }

    public int getPort() {
        return ((ServerConnector) server.getConnectors()[0]).getLocalPort();
    }

    public void shutdown() throws Exception {
        server.stop();
        server.join();
    }
}
