import IdeSettings.packagePrefix
import sbt._
import sbt.Keys._

ThisBuild / name        := "scala-library-template"
ThisBuild / description := "A reusable template for Scala libraries."

ThisBuild / homepage :=
  Some(url("https://github.com/SgtSwagrid/scala-library-template"))

ThisBuild / organization         := "com.example"
ThisBuild / organizationName     := "Example"
ThisBuild / organizationHomepage := Some(url("https://example.com"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/SgtSwagrid/scala-library-template"),
  "scm:git@github.com:SgtSwagrid/scala-library-template.git",
))

ThisBuild / developers := List(Developer(
  id = "example",
  name = "Example Developer",
  email = "dev@example.com",
  url = url("https://github.com/example"),
))

ThisBuild / licenses :=
  List("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0"))

// Target the Sonatype Central Portal (https://central.sonatype.com).
// Set SONATYPE_USERNAME and SONATYPE_PASSWORD as GitHub secrets.
ThisBuild / sonatypeCredentialHost := "central.sonatype.com"
ThisBuild / publishMavenStyle      := true
Global / excludeLintKeys ++= Set(name, publishMavenStyle)

lazy val root = (project in file(".")).settings(
  packagePrefix                          := (ThisBuild / organization).value,
  libraryDependencies += "org.scalameta" %% "munit" % "1.2.4" % Test,
)
