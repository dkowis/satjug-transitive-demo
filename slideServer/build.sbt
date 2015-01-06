import spray.revolver.RevolverPlugin._

val jettyServer = "org.eclipse.jetty" % "jetty-server" % "9.2.0.v20140526"

lazy val root = (project in file(".")).
  settings(Revolver.settings: _*).
  settings(
    name := "slide-server",
    version := "1.0",
    scalaVersion := "2.11.4",
    libraryDependencies += jettyServer
  )
