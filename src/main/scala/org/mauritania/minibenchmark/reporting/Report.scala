package org.mauritania.minibenchmark.reporting

import java.io.{File, FileWriter}

case class Report(
  vsSamples: Seq[VersusSample],
  seed: Int
) {

  def printConclusion(): Report = {
    println(generateResultLine)
    this
  }

  def generateTable(): Seq[VersusSampleRow] = {
    vsSamples.map { vsSample =>
      VersusSampleRow(
        vsSample.sampleA.duration,
        vsSample.sampleB.duration
      )
    }
  }


  def generateResultLine(): VersusReportRow = {
    val algNameA = vsSamples.head.sampleA.id
    val algNameB = vsSamples.head.sampleB.id

    val durationA = vsSamples.map(s => s.sampleA.duration).sum
    val durationB = vsSamples.map(s => s.sampleB.duration).sum

    val ratio = if (durationA > durationB) {
      durationB.toDouble / durationA
    } else {
      durationA.toDouble / durationB
    }

    VersusReportRow(algNameA, algNameB, durationA, durationB, ratio)

  }

}

object Report {

  def save(f: File, reports: Seq[Report]) = {
    if (!f.exists()) {
      f.createNewFile()
    }
    new FileWriter(f) {
      reports.foreach{rep =>
        append(rep.generateResultLine().toString())
      }
      close()
    }
    this
  }

}
