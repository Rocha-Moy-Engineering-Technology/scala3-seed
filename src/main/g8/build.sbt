ThisBuild / scalaVersion := "3.3.0-RC6"
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
  "-language:implicitConversions",
  "-new-syntax",
  "-unchecked"
)

lazy val myLibraryDependencies = libraryDependencies ++= Seq()

lazy val settings = myScalacOptions ++ myLibraryDependencies

lazy val depedencyGraph = "compile->compile;compile->test;test->compile;test->test"

lazy val $name;format="lower,word"$ = project
  .in(file("."))
  .settings(settings)
  .dependsOn($name;format="lower,word"$_utils % depedencyGraph)
  .dependsOn($base$ % depedencyGraph)
  .aggregate($name;format="lower,word"$_utils,$base$)

lazy val $name;format="lower,word"$_utils = project
  .in(file("utils"))
  .settings(settings, organization := "$organization$.$name;format="lower,word"$")
  .dependsOn($base$ % depedencyGraph)
  .aggregate($base$)

lazy val $base$ = RootProject(file("../$base$"))


ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
