package $org$.$name;format="norm"$

import org.rogach.scallop._

case class AppConf(arguments: Seq[String]) extends ScallopConf(arguments) {

  version("preprocessing-report 0.1.0")

  // TODO: add example opts here
}



class Main extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) =
    new Exit(Main.exec(config.arguments))
}

case class Exit(val code: Int) extends xsbti.Exit

object Main {

  def exec(args: Array[String]): Int = {

    // create conf from args
    val conf = AppConf(args)

    0
  }
}