ThisBuild / scalaVersion := "3.2.2" //TODO: automate scalaVersion
ThisBuild / organization := "$organization$"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val `$name;format="space,hyphen"$` = project
  .in(file("."))
  .settings(
    scalacOptions ++= Seq(
      "-Werror",
      "-Wunused:all",
      "-Ycheck-all-patmat",
      "-Ycheck-mods",
      "-Ycheck-reentrant",
      "-Yexplain-lowlevel",
      "-Yexplicit-nulls",
      "-Ykind-projector:underscores",
      "-Yno-deep-subtypes",
      "-Yno-double-bindings",
      "-Yrequire-targetName",
      "-Yresolve-term-conflict:error",
      "-Ysafe-init",
      "-Yshow-suppressed-errors",
      "-deprecation",
      "-encoding",
      "utf8",
      "-explain",
      "-explain-types",
      "-feature",
      "-indent",
      "-language:higherKinds",
      "-language:strictEquality",
      "-new-syntax",
      "-rewrite",
      "-unchecked"
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
