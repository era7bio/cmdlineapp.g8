resolvers ++= Seq(
  "Era7 maven releases" at "http://releases.era7.com.s3.amazonaws.com"
)

addSbtPlugin("ohnosequences" % "nice-sbt-settings" % "0.4.0-RC2")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.3.1")
