name    := "clrs-scala"
version := "0.1"

ThisBuild / scalaVersion := "2.13.4"

scalacOptions ++= List("-deprecation")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
  "org.scalacheck"         %% "scalacheck"                 % "1.15.2"  % Test,
  "org.scalatest"          %% "scalatest"                  % "3.2.3"   % Test,
  "org.scalatestplus"      %% "scalacheck-1-14"            % "3.2.2.0" % Test,
)

Test / logBuffered := false
