ThisBuild / scalaVersion := "3.2.1"
ThisBuild / organization := "$organization$"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val `$name;format="space,hyphen"$` = project
  .in(file("."))
  .settings(
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
      "org.scalatest" %% "scalatest" % "[0,1000)" % Test,
      "org.scalacheck" %% "scalacheck" % "[0,1000)" % Test,
      "org.scalatestplus" %% "scalacheck-1-17" % "[0,1000)" % Test,
      "org.scala-lang.modules" %% "scala-parallel-collections" % "[0,1000)"
    )
  )

ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
