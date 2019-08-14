scalaVersion     := "2.13.0"
version          := "0.1.0-SNAPSHOT"
organization     := "com.example"
organizationName := "example"

name := "parser"

libraryDependencies ++= Seq(
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "0.55.0" % Compile,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "0.55.0" % Provided,
)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
