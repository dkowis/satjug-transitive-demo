package org.satjug

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class JettyTest extends FunSpec with Matchers {

  it("should provide a port that the jetty started on") {
    val app = new App()
    app.main() //side effecting to start jetty up

    app.getPort.isInstanceOf[Int] shouldBe true
  }




}
