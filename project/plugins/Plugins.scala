import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val ideaRepo = "GH-pages repo" at "http://mpeltonen.github.com/maven/"
  val bnd4sbtRepo = "aQute Maven Repository" at "http://www.aqute.biz/repo"

  lazy val aquteModuleConfig = ModuleConfiguration("biz.aQuote", bnd4sbtRepo)

  lazy val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
  lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.6.0"
  lazy val bnd4sbt = "com.weiglewilczek.bnd4sbt" % "bnd4sbt" % "1.0.0.RC6"
}

