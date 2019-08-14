import pl.project13.scala.sbt.JmhPlugin

scalaVersion     := "2.13.0"
version          := "0.1.0-SNAPSHOT"
organization     := "com.example"
organizationName := "example"

name := "benchmark"

enablePlugins(JmhPlugin)
