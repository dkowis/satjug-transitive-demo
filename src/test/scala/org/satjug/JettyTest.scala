package org.satjug

import org.apache.http.client.fluent.Request
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class JettyTest extends FunSpec with Matchers {


  it("provides a way to shutdown the server") {
    val app = new App()
    app.main()

    app.shutdown()
  }

  it("doesn't return from main until the server is running") {
    val app = new App()

    app.main()

    app.isUp should be(true)
    app.shutdown()
  }

  it("should provide a port that the jetty started on") {
    val app = new App()
    app.main() //side effecting to start jetty up

    app.getPort.isInstanceOf[Int] shouldBe true
    app.shutdown()
  }

  it("should serve resources out of the resources jar path") {
    val app = new App()
    app.main()

    val port = app.getPort

    val content = Request.Get(s"http://localhost:$port/helo.txt").execute().returnContent().asString

    content should be("Hello World")
  }


}
