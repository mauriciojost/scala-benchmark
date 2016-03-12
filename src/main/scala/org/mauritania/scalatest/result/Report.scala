package org.mauritania.scalatest.result

import java.io.{File, PrintWriter}

case class Report (
  vsSamples : List[VsSample]
) {

  val NL = "\n"

  def printConclusion(): Report = {
    println(generateConclusion)
    this
  }

  def printTable(): Report = {
    println(generateTable())
    this
  }

  def generateTable(): String = {

    val sep = "\t|\t"

    val saName = vsSamples.head.sampleA.id
    val sbName = vsSamples.head.sampleB.id

    val s = new StringBuilder()
    s.append(NL)
    s.append(saName + sep + sbName)
    vsSamples.foreach { vsSample =>
      s.append(vsSample.sampleA.duration + sep + vsSample.sampleB.duration)
      s.append(NL)
    }
    s.append(NL)

    s.toString()
  }


  def generateConclusion(): String = {
    val saName = vsSamples.head.sampleA.id
    val sbName = vsSamples.head.sampleB.id

    val sa = vsSamples.map(s => s.sampleA.duration).sum
    val sb = vsSamples.map(s => s.sampleB.duration).sum

    val s = new StringBuilder()
    s.append(NL)
    if (sa > sb) {
      s.append("\'" + sbName + "\' is faster than \'" + saName + "\': executed in " + ((sb * 100 / sa)) + "% of time")
      s.append(NL)
    } else {
      s.append("\'" + saName + "\' is faster than \'" + sbName + "\': executed in " + ((sa * 100 / sb)) + "% of time")
      s.append(NL)
    }
    s.append(NL)
    s.toString()
  }

  def save() = {
    import scala.sys.process._
    val logs: String = "results"
    val commitId: String = "git rev-parse HEAD".!!
    new PrintWriter(new File(logs, commitId)) { write(generateTable());write(generateConclusion()); close }
    this
  }

}
