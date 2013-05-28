package $org$.$name;format="norm"$

import org.rogach.scallop._

case class AppConf(arguments: Seq[String]) extends ScallopConf(arguments) {

  version("preprocessing-report 0.1.0")

  val prefix = opt[String](
                            required = true, short = 'p',
                            descr = "this is the prefix you used when running prinseq. It will be used to identify the dataset"
                          )

  val output = opt[String](
                            required = false, short = 'o',
                            descr = "output file name"
                            // this is just the wrapped Option inside ScallopOption
                            // default = prefix.get
                          )

  
  // template vals
  val sequencing_provider =  opt[String](
                                          required = true,
                                          descr = "the sequencing provider from which the data comes from",
                                          noshort = true
                                        )

  val sequencing_technology =  opt[String](
                                            required = true,
                                            descr = "the sequencing technology used for generating data",
                                            noshort = true
                                          )

  val reads_type = opt[String](
                                required = true, noshort = true,
                                descr = "type of reads (paired-end, single, whatever)"
                              )

  val data_reception_date =  opt[String](
                                          required = true, noshort = true,
                                          descr = "the date on which data was received from the provider"
                                        )

  val total_number_reads = opt[String](
                                        required = true, noshort = true,
                                        descr = "the total number of reads, counting from all inputs"
                                      )

  val total_number_bases = opt[String](
                                        required = true, noshort = true,
                                        descr = "the total number of bases, counting from all inputs"
                                      )

  val mean_qual_threshold =  opt[String](
                                          required = true, noshort = true,
                                          descr = "the mean quality score used to filter reads"
                                        )

  val trim_qual_threshold =  opt[String](
                                          required = true, noshort = true,
                                          descr = "the mean quality score used to trim reads on both ends"
                                        )

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