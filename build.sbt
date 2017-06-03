name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.2"

lazy val akkaVersion = "2.5.2"

mainClass := Some("com.a4r.Main")

libraryDependencies ++= Seq(
  "com.github.scopt" %% "scopt" % "3.6.0",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.0.6",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.6" % Test,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion, 
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-distributed-data" % "2.5.2",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
