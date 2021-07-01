lazy val root =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      organization := "io.github.mavenrain",
      name := "shaka-caliban-client",
      version := "0.1.0-SNAPSHOT",
      versionScheme := Some("early-semver"),
      scalaVersion := "3.0.0",
      // todo remove when fixed: https://github.com/lampepfl/dotty/issues/11943
      Compile / doc / sources := Seq(),
      scalaJSUseMainModuleInitializer := true,
      libraryDependencies ++= Seq(
        "com.github.ghostdogpr" %%% "caliban-client" % "1.0.1",
        "org.getshaka" %%% "shaka" % "0.3.0",
        ("dev.zio" %%% "zio" % "1.0.9")
          .cross(CrossVersion.for3Use2_13)
      )
    )

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}
dockerExposedPorts += 9000
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(CodegenPlugin)