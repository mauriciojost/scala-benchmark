package org.mauritania.minibenchmark

import org.mauritania.minibenchmark.reporting.{Report, ReportFile}

object CompareApp {

  def main(args: Array[String]): Unit = {

    val className = args(0)
    val iterations = args(1).toInt
    val seedsFromRange = args(2).toInt
    val seedsToRange = args(3).toInt
    val seedsStepRange = args(4).toInt

    val versusInstance = Class.forName(className).newInstance().asInstanceOf[Versus]
    val seedsRange = Range(seedsFromRange, seedsToRange, seedsStepRange)
    val reports = VersusBenchmark.benchmarkInRange(versusInstance, seedsRange, iterations)
    Report.save(ReportFile.reportFile(), reports)

  }


}
