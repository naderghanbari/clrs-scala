name         := "clrs-scala"
version      := "0.1"
scalaVersion := "2.13.0-RC1"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scalacheck"         %% "scalacheck"                 % "1.14.0" % Test,
  "org.scalatest"          %% "scalatest"                  % "3.0.8-RC3" % Test,
  "org.scalatestplus"      %% "scalatestplus-scalacheck"   % "1.0.0-SNAP5" % Test,
)
