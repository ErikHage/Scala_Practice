scalaVersion := "2.10.4"

name := "Scala_Practice"

version := "1.0"

autoCompilerPlugins := true

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:_",
  "-P:continuations:enable"
)

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Akka Repo" at "http://akka.io/repository",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/repo",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies <+= scalaVersion { v => compilerPlugin(
  "org.scala-lang.plugins" % "continuations" % v) }

libraryDependencies ++= Seq(
  "org.mongodb" % "mongo-java-driver" % "2.10.1",
//  "org.scala-lang.modules" % "scala-xml_2.10" % "1.0.6",
  "org.scalaz" % "scalaz-core_2.10" % scalazVersion,
  "org.scalaz" % "scalaz-http_2.10" % scalazVersion,
  "org.eclipse.jetty" % "jetty-servlet" % jettyVersion % "container",
  "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "test,container",
  "org.eclipse.jetty" % "jetty-server" % jettyVersion % "container",
  "com.h2database" % "h2" % "1.4.195",
  "org.squeryl" %% "squeryl" % "0.9.5-7",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.1.0",
  "joda-time" % "joda-time" % "2.8.1",
  "com.typesafe.akka" % "akka-remote_2.10" % "2.1.0",
  "com.typesafe.akka" %% "akka-agent" % "2.1.0",
//  "com.typesafe.akka." % " akka-dataflow_2.10" % "2.1.0",
  "org.scala-stm" %% "scala-stm" % "0.7",

  "org.scalacheck" %% "scalacheck" % "1.10.0",
  "junit" % "junit" % "4.10",
  "com.novocode" % "junit-interface" % "0.8",
  "org.specs2" %% "specs2" % "1.13"
)

enablePlugins(JettyPlugin)