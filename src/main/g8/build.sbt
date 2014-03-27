Nice.scalaProject

organization := "$org$"

name := "$name$"

description := "$name$ project"

bucketSuffix := "era7.com"

docsOutputDir := "docs/src/"

resolvers ++= Seq ( 
    Resolver.typesafeRepo("releases")
  , Resolver.sonatypeRepo("releases")
  , Resolver.sonatypeRepo("snapshots")
  , "Era7 Releases"  at "http://releases.era7.com.s3.amazonaws.com"
  , "Era7 Snapshots" at "http://snapshots.era7.com.s3.amazonaws.com"
  )

libraryDependencies ++= Seq (
    "org.rogach" %% "scallop" % "0.9.5"
  )

// sbt-buildinfo settings

buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)
