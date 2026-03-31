import sbt._
import sbt.Keys._

ThisBuild / name           := "Scala Library Template"
ThisBuild / normalizedName := "scala-library-template"

ThisBuild / organization         := "org.example"
ThisBuild / organizationName     := "Example"
ThisBuild / organizationHomepage := Some(url("https://github.com/SgtSwagrid/scala-library-template"))

ThisBuild / scalaVersion  := "3.8.2"
ThisBuild / versionScheme := Some("strict")

ThisBuild / licenses :=
  List("MIT License" -> url("https://opensource.org/licenses/MIT"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/SgtSwagrid/scala-library-template"),
  "scm:git@github.com:SgtSwagrid/scala-library-template.git",
))

ThisBuild / developers := List(
  Developer(
    id = "example",
    name = "Example Example",
    email = "example@example.com",
    url = url("http://github.com/example")
  )
)

// Target the Sonatype Central Portal (https://central.sonatype.com).
// Requires SONATYPE_USERNAME and SONATYPE_PASSWORD as GitHub secrets or environment variables.
ThisBuild / sonatypeCredentialHost := "central.sonatype.com"
ThisBuild / publishMavenStyle      := true
Global    / excludeLintKeys ++= Set(publishMavenStyle)
