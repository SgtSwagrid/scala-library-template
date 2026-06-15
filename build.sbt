import IdeSettings.packagePrefix
import sbt._
import sbt.Keys._
import sbtunidoc.BaseUnidocPlugin.autoImport.*
import sbtunidoc.ScalaUnidocPlugin

ThisBuild / scalaVersion := "3.8.3"

scalacOptions ++= Seq(
  "-explain",
  "-explain-types",
  "-explain-cyclic",
)

lazy val `scala-library-template` = project
  .in(file("."))
  .enablePlugins(ScalaUnidocPlugin)
  .settings(
    packagePrefix                          := "com.alecdorrington",
    libraryDependencies += "org.scalameta" %% "munit" % "1.3.3" % Test,
    ScalaUnidoc / unidoc / scalacOptions ++=
      Seq("-project", "Scala Library Template"),
  )
