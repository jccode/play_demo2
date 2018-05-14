name := "play_demo2"
 
version := "1.0"

scalaVersion := "2.12.5"
      
lazy val `play_demo2` = (project in file(".")).enablePlugins(PlayScala)

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  guice,

  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "com.h2database" % "h2" % "1.4.196",

  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.typelevel" %% "cats-core" % "1.1.0",

  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % "test",

  "com.github.jccode" %% "slickx-play" % "0.1",
)


lazy val slick = taskKey[Seq[File]]("gen-tables")  // register manual sbt command
slick := {
  val (dir, cp, r, s) = ((sourceManaged in Compile).value, (dependencyClasspath in Compile).value, (runner in Compile).value, streams.value)
  val pkg = "dao"
  val slickProfile = "slick.jdbc.H2Profile"
  val jdbcDriver = "org.h2.Driver"
  val url = "jdbc:h2:./play"
  val user = "sa"
  val password = ""
  val included = ""
  val excluded = "PLAY_EVOLUTIONS"
  r.run("com.github.jccode.slickx.codegen.CodeGenerator", cp.files, Array(slickProfile, jdbcDriver, url, dir.getPath, pkg, user, password, "true", "com.github.jccode.slickx.codegen.PlayCodeGenerator", included, excluded), s.log)
  val outputFile = dir / pkg.replace(".", "/") / "Tables.scala"
  Seq(outputFile)
}
//sourceGenerators in Compile += slick
