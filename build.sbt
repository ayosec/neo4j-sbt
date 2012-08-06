import AssemblyKeys._

organization := "com.ayosec"

name := "tryneo"

version := "0.1"

libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j-lucene-index" % "1.7" exclude("org.neo4j", "neo4j-udc")
)

/** Repos for Neo4j Admin server dep */
resolvers ++= Seq(
  "tinkerprop" at "http://tinkerpop.com/maven2",
  "neo4j-public-repository" at "http://m2.neo4j.org/releases"
)

scalaSource in Compile := file("src")


assemblySettings

mainClass in assembly := Some("com.ayosec.tryneo.test")

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case "META-INF/LICENSES.txt" => MergeStrategy.discard
    case "META-INF/CHANGES.txt" => MergeStrategy.discard
    case x => old(x)
  }
}
