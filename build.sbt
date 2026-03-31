import sbt._
import sbt.Keys._
import IdeSettings.packagePrefix

lazy val `scala-library-template` = (project in file(".")).settings(
  packagePrefix := "io.github.sgtswagrid",
  libraryDependencies += "org.scalameta" %% "munit" % "1.2.4" % Test,
)
