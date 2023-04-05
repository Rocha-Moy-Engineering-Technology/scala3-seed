ThisBuild / scalaVersion := "3.2.2"
ThisBuild / organization := "$organization$"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val myScalacOptions = scalacOptions ++= Seq(
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
  "-unchecked"
)

lazy val myLibraryDependencies = libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.scalacheck" %% "scalacheck" % "1.17.0" % Test,
  "org.scalatestplus" %% "scalacheck-1-17" % "3.2.15.0" % Test,
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
)

lazy val settings = myScalacOptions ++ myLibraryDependencies

lazy val depedencyGraph = "compile->compile;compile->test;test->compile;test->test"

lazy val $name;format="lower,word"$ = project
  .in(file("."))
  .settings(settings)
  .dependsOn(core % depedencyGraph)
  .dependsOn(utils % depedencyGraph)
  .aggregate(core,utils)

lazy val core = project
  .in(file("core"))
  .settings(settings, organization := "$organization$.$name;format="lower,word"$")
  .dependsOn(utils % depedencyGraph)
  .aggregate(utils)

lazy val utils = project
  .in(file("utils"))
  .settings(settings, organization := "$organization$.$name;format="lower,word"$")

ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
