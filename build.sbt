lazy val parser = project in file("parser")

lazy val benchmark = (project in file("benchmark")).dependsOn(parser)

ThisBuild / scalaVersion := "2.13.0"
