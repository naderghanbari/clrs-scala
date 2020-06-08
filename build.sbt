name    := "clrs-scala"
version := "0.1"

ThisBuild / scalaVersion := "2.13.2"

scalacOptions ++= List("-deprecation")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scalacheck"         %% "scalacheck"                 % "1.14.3" % Test,
  "org.scalatest"          %% "scalatest"                  % "3.1.2" % Test,
  "org.scalatestplus"      %% "scalatestplus-scalacheck"   % "3.1.0.0-RC2" % Test,
)

Test / logBuffered := false
