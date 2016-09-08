package org.mauritania.minibenchmark

import org.mauritania.minibenchmark.catalog._
import org.mauritania.minibenchmark.reporting.{Report, ReportFile}

object StarterAll {

  def main(args: Array[String]): Unit = {

    val iterationsFactor = 1

    val reports = List(
      VersusBenchmark.benchmark(Identity, 500, 200 * iterationsFactor),
      VersusBenchmark.benchmark(IdentityX2, 500, 200 * iterationsFactor),
      VersusBenchmark.benchmark(IdentityX4, 500, 200 * iterationsFactor),
      VersusBenchmark.benchmark(TailRecursive, 500, 200 * iterationsFactor),
      VersusBenchmark.benchmark(SeqVsListSum, 50, 100 * iterationsFactor),
      VersusBenchmark.benchmark(ListVsVectorConcatenation, 10, 200 * iterationsFactor),
      VersusBenchmark.benchmark(ListVsArrayConcatenation, 10, 400 * iterationsFactor),
      VersusBenchmark.benchmark(ListVsArrayPatternMatching, 600, 400 * iterationsFactor),
      VersusBenchmark.benchmark(ListVsVectorPatternMatching, 600, 4000 * iterationsFactor),
      VersusBenchmark.benchmark(ListVsVectorRandomAccess, 200, 4000 * iterationsFactor),
      VersusBenchmark.benchmark(PartialFunctions, 500000, 1 * iterationsFactor)
    )

    Report.save(ReportFile.reportFile(), reports)

  }


}
