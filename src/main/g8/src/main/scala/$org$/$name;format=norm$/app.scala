package $org$.$name;format="norm"$

import org.rogach.scallop._
import buildinfo._

// this is your conf class, see the Scallop docs for how to use this
case class AppConf(arguments: Seq[String]) extends ScallopConf(arguments) {

  // this will be displayed when you execute $cmdline_name$ --version
  version("$cmdline_name$ %s" format BuildInfo.version)

  // TODO: add example opts here
}


// this is the class that the sbt-launcher will use
class Main extends xsbti.AppMain {
  
  def run(config: xsbti.AppConfiguration) = new Exit(Main.exec(config.arguments))
}

case class Exit(val code: Int) extends xsbti.Exit

object Main {

  // this is where your actual code lives
  // return 0 if success, any other integer if not
  def exec(args: Array[String]): Int = {

    // create conf from args
    val conf = AppConf(args)

    // success!
    0
  }

  // for testing within sbt
  // 'run <args>' will execute your cmdline app
  def main(args: Array[String]): Unit = exec(args)
}
