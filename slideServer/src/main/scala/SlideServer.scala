package org.satjug

import org.eclipse.jetty.server.handler.{DefaultHandler, HandlerList, ResourceHandler}
import org.eclipse.jetty.server.{Server, ServerConnector}
import org.eclipse.jetty.util.resource.Resource

object SlideServer extends App {

  val jetty = new Server()
  val http = new ServerConnector(jetty)
  http.setHost("localhost")
  http.setPort(9876)
  http.setIdleTimeout(30000)

  val handler = new ResourceHandler()
  handler.setDirectoriesListed(false)
  handler.setWelcomeFiles(List("index.html").toArray)
  handler.setBaseResource(Resource.newClassPathResource("/slides"))

  val handlerList = new HandlerList()
  handlerList.setHandlers(List(handler, new DefaultHandler()).toArray)

  jetty.setHandler(handlerList)

  jetty.addConnector(http)
  jetty.start()

  println(s"Jetty ready to go: http://localhost:${http.getLocalPort}/")

  jetty.join()

}
