import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val repo = "GH-pages repo" at "http://mpeltonen.github.com/maven/"

  lazy val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
  lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.6.0"
}

