import sbt._

object Dependencies {
  val circeVersion = "0.12.3"

  val dependencies =
    Seq(
      compilerPlugin(
        "org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.full
      ),
      compilerPlugin(
        "org.augustjune" %% "context-applied" % "0.1.2"
      )
    ) ++ Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.typelevel" %% "cats-core" % "2.3.1",
      "org.typelevel" %% "kittens" % "2.0.0",
      "org.typelevel" %% "cats-effect" % "2.1.0",
      "dev.profunktor" %% "console4cats" % "0.8.1",
      "org.manatki" %% "derevo-cats" % "0.10.5",
      "org.manatki" %% "derevo-cats-tagless" % "0.10.5",
      "co.fs2" %% "fs2-core" % "2.2.2",
      "com.olegpy" %% "meow-mtl-core" % "0.4.0",
      "com.olegpy" %% "meow-mtl-effects" % "0.4.0",
      "io.estatico" %% "newtype" % "0.4.3",
      "eu.timepit" %% "refined" % "0.9.12",
      "com.github.julien-truffaut" %% "monocle-core" % "2.0.1",
      "com.github.julien-truffaut" %% "monocle-macro" % "2.0.1",
      "org.scala-steward" %% "scala-steward-core" % "0.8.1"
    ) ++ Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
}
