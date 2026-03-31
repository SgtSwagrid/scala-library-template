import IdeSettings.packagePrefix
import sbt._
import sbt.Keys._

lazy val `scala-library-template` = (project in file(".")).settings(
  packagePrefix                          := "io.github.sgtswagrid",
  libraryDependencies += "org.scalameta" %% "munit" % "1.2.4" % Test,
)
