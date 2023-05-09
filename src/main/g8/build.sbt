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
  .dependsOn($name;format="lower,word"$_utils % depedencyGraph)
  .dependsOn(sccore % depedencyGraph)
  .aggregate($name;format="lower,word"$_utils,sccore)

lazy val $name;format="lower,word"$_utils = project
  .in(file("utils"))
  .settings(settings, organization := "$organization$.$name;format="lower,word"$")
  .dependsOn(sccore % depedencyGraph)
  .aggregate(sccore)

lazy val sccore = RootProject(file("../sccore"))


ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
