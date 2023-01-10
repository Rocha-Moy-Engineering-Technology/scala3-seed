ThisBuild / scalaVersion := "3.2.1"
ThisBuild / organization := "$organization$"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3",
    scalacOptions ++= Seq(
      "-Yexplicit-nulls",
      "-language:strictEquality",
      "-language:higherKinds",
      "-Yrequire-targetName",
      "-Werror",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-explain-types",
      "-explain",
      "-new-syntax",
      "-Ycheck-all-patmat",
      "-Ycheck-mods",
      "-Ycheck-reentrant",
      "-Yno-double-bindings",
      "-Yshow-suppressed-errors",
      "-Wunused:all",
      "-Yno-deep-subtypes",
      "-Yresolve-term-conflict:error",
      "-encoding",
      "utf8",
      "-Ykind-projector:underscores",
      "-Ysafe-init"
    ),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "latest.release" % Test
    )
  )

ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
