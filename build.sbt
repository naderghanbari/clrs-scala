name    := "clrs-scala"
version := "0.1"

ThisBuild / scalaVersion := "2.13.3"

scalacOptions ++= List("-deprecation")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scalacheck"         %% "scalacheck"                 % "1.14.3"  % Test,
  "org.scalatest"          %% "scalatest"                  % "3.2.2"   % Test,
  "org.scalatestplus"      %% "scalacheck-1-14"            % "3.2.2.0" % Test,
)

Test / logBuffered := false
