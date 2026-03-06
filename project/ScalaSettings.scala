import sbt.*
import sbt.Keys.*

/** Library-wide Scala and Java compiler flags. */
object ScalaSettings extends AutoPlugin {

  override def trigger = allRequirements

  override lazy val buildSettings = Seq(
    scalacOptions ++= Seq(
      // Enable new experimental features:
      "-language:experimental.subCases",
      "-language:experimental.relaxedLambdaSyntax",
      "-language:experimental.multiSpreads",
      "-language:experimental.strictEqualityPatternMatching",

      // Allow additional function call inlining:
      "-Xmax-inlines",
      "64",
    ),

    // The Scala version to target:
    scalaVersion := "3.8.2",
  )
}
