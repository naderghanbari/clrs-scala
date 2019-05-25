name         := "clrs-scala"
version      := "0.1"
scalaVersion := "2.13.0-RC2"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scalacheck"         %% "scalacheck"                 % "1.14.0" % Test,
  "org.scalatest"          %% "scalatest"                  % "3.0.8-RC4" % Test,
  "org.scalatestplus"      %% "scalatestplus-scalacheck"   % "1.0.0-SNAP6" % Test,
)
