ThisBuild / scalaVersion := "3.5.0"
ThisBuild / organization := "$organization$"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val myScalacOptions = scalacOptions ++= Seq(
  "-Wconf:any:error",
  "-Wenum-comment-discard",
  "-Werror",
  "-Wimplausible-patterns",
// "-Wnonunit-statement",
  "-Wsafe-init",
  "-Wshadow:all",
  // "-WunstableInlineAccessors",
  "-Wunused:all",
  "-Wvalue-discard",
  "-Ybackend-parallelism:16",
  "-Ybackend-worker-queue:1000",
// "-Ycheck:all",
  "-Ycheck-all-patmat",
  "-Ycheck-constraint-deps",
  "-Ycheck-mods",
  "-Ycheck-reentrant",
  "-Ydebug",
  "-Ydebug-cyclic",
  "-Ydebug-missing-refs",
  "-Ydebug-type-error",
  "-Ydebug-unpickling",
  "-Yexplain-lowlevel",
// "-Yexplicit-nulls",
// "-Ylog:all"
  "-Yno-deep-subtypes",
  "-Yno-double-bindings",
  "-Yno-suspended-units",
  "-Yprint-debug",
  "-Yrequire-targetName",
  "-Ysafe-init-global",
  "-Yshow-print-errors",
  "-Yshow-suppressed-errors",
  "-Xcheck-macros",
  "-Xdebug-macros",
  "-Xkind-projector:underscores",
  "-Xmax-inlines:512",
  "-Xsemanticdb",
  "-deprecation",
  "-explain",
  "-explain-cyclic",
  "-feature",
  "-language:dynamics",
  "-language:existentials",
  "-language:higherKinds",
  "-language:strictEquality",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-new-syntax",
  "-source:future",
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
