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

  lazy val traceCore = project("trace-core", "Trace Core", info => new TraceCoreProject(info))
  lazy val traceLocal = project("trace-local", "Trace Local", info => new TraceLocalProject(info), traceCore)
  lazy val traceNetworkCore = project("trace-network-core", "Trace Network Core", info => new TraceNetworkCoreProject(info), traceCore)
  lazy val traceNetworkClient = project("trace-network-client", "Trace Network Client", info => new TraceNetworkClientProject(info), traceCore, traceNetworkCore)
  lazy val traceNetworkServer = project("trace-network-server", "Trace Network Server", info => new TraceNetworkServerProject(info), traceCore, traceNetworkCore)

  class TraceProject(info: ProjectInfo)
    extends DefaultProject(info)
    with BNDPlugin
  {
    override lazy val bndExecutionEnvironment = Set(Java6)
    override lazy val bndBundleVendor         = Some("Data Fueled (http://www.datafueled.com/)")
    override lazy val bndBundleLicense        = Some("Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0)")
    override lazy val bndVersionPolicy        = Some("[$(@),$(@)]")
  }

  class TraceCoreProject(info: ProjectInfo)
    extends TraceProject(info)
  {
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.core.*;version=%s".format(projectVersion.value))
  }

  class TraceLocalProject(info: ProjectInfo)
    extends TraceProject(info)
  {
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.local.*;version=%s".format(projectVersion.value))
  }

  class TraceNetworkCoreProject(info: ProjectInfo)
    extends TraceProject(info)
  {
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.network.core.*;version=%s".format(projectVersion.value))
  }

  class TraceNetworkClientProject(info: ProjectInfo)
    extends TraceProject(info)
  {
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.network.client.*;version=%s".format(projectVersion.value))
  }

  class TraceNetworkServerProject(info: ProjectInfo)
    extends TraceProject(info)
  {
    override lazy val bndExportPackage        = Seq("com.datafueled.trace.network.server.*;version=%s".format(projectVersion.value))
  }
}

