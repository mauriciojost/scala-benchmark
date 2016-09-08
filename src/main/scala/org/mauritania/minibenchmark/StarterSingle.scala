package org.mauritania.minibenchmark

import org.mauritania.minibenchmark.catalog.PartialFunctions

object StarterSingle {

  def main(args: Array[String]): Unit = {

    val iterations = 200
    val versus = PartialFunctions

    println(VersusBenchmark.benchmark(versus, 10, iterations).generateResultLine())
    println(VersusBenchmark.benchmark(versus, 1000, iterations).generateResultLine())
    println(VersusBenchmark.benchmark(versus, 10000, iterations).generateResultLine())
    println(VersusBenchmark.benchmark(versus, 100000, iterations).generateResultLine())
    println(VersusBenchmark.benchmark(versus, 1000000, iterations).generateResultLine())

    //GCR.testComparables(PartialFunctions, 10000, 10000)


  }


}
