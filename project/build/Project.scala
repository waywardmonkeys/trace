import sbt._
import de.element34.sbteclipsify._
import com.weiglewilczek.bnd4sbt.BNDPlugin
import com.weiglewilczek.bnd4sbt.ExecutionEnvironment._

class Project(info: ProjectInfo) extends DefaultProject(info)
  with IdeaProject
  with Eclipsify
  with BNDPlugin
{
  val junitVersion = "4.8.1"
  val scalaTestVersion = "1.2"

    // OSGi stuff
  override lazy val bndExecutionEnvironment = Set(Java6)
  override lazy val bndBundleVendor         = Some("Data Fueled (http://www.datafueled.com/)")
  override lazy val bndBundleLicense        = Some("Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0)")
  override lazy val bndVersionPolicy        = Some("[$(@),$(@)]")
  override lazy val bndExportPackage        = Seq("com.datafueled.trace.*;version=%s".format(projectVersion.value))

  val scalaTest = "org.scalatest" % "scalatest" % scalaTestVersion % "test"
  val junit = "junit" % "junit" % junitVersion % "test"
}

