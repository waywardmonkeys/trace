import sbt._
import de.element34.sbteclipsify._
import com.weiglewilczek.bnd4sbt.BNDPlugin
import com.weiglewilczek.bnd4sbt.ExecutionEnvironment._

class Project(info: ProjectInfo) extends ParentProject(info)
  with IdeaProject
  with Eclipsify
{
  val junitVersion = "4.8.1"
  val scalaTestVersion = "1.2"

  val scalaTest = "org.scalatest" % "scalatest" % scalaTestVersion % "test"
  val junit = "junit" % "junit" % junitVersion % "test"

  lazy val traceCore = project(
    path("trace-core"),
    "trace-core",
    new TraceProject(_))
  lazy val traceLocal = project(
    path("trace-local"),
    "trace-local",
    new TraceProject(_),
    traceCore)
  lazy val traceNetworkCore = project(
    path("trace-network-core"),
    "trace-network-core",
    new TraceProject(_),
    traceCore)
  lazy val traceNetworkClient = project(
    path("trace-network-client"),
    "trace-network-client",
    new TraceProject(_),
    traceCore, traceNetworkCore)
  lazy val traceNetworkServer = project(
    path("trace-network-server"),
    "trace-network-server",
    new TraceProject(_),
    traceCore, traceNetworkCore)

  trait OSGiProject extends BNDPlugin { self: DefaultProject =>
    override lazy val bndExecutionEnvironment = Set(Java6)
    override lazy val bndBundleVendor         = Some("Data Fueled (http://www.datafueled.com/)")
    override lazy val bndBundleLicense        = Some("Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0)")
    override lazy val bndVersionPolicy        = Some("[$(@),$(@)]")
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.*;version=%s".format(projectVersion.value))
  }

  class TraceProject(info: ProjectInfo)
    extends DefaultProject(info)
    with IdeaProject
    with OSGiProject
  {
  }
}

