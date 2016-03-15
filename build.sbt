
name := "scala-mini-benchmark"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.storm-enroute" %% "scalameter" % "0.7" % "test" // ScalaMeter version is set in version.sbt
)
