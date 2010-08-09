import sbt._
import de.element34.sbteclipsify._

class Project(info: ProjectInfo) extends DefaultProject(info) with IdeaProject with Eclipsify {
  val junitVersion = "4.8.1"
  val scalaTestVersion = "1.2"

  val scalaTest = "org.scalatest" % "scalatest" % scalaTestVersion % "test"
  val junit = "junit" % "junit" % junitVersion % "test"
}

