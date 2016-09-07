package org.mauritania.scalatest.result

case class Report(
  vsSamples: List[VsSample],
  seed: Int
) {

  val NL = "\n"

  def printConclusion(): Report = {
    println(generateResultLine)
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
    s.append(saName)
    s.append(sep)
    s.append(sbName)
    s.append(NL)
    vsSamples.foreach { vsSample =>
      s.append(vsSample.sampleA.duration)
      s.append(sep)
      s.append(vsSample.sampleB.duration)
      s.append(NL)
    }
    s.append(NL)

    s.toString()
  }


  def generateResultLine(): String = {
    val algNameA = vsSamples.head.sampleA.id
    val algNameB = vsSamples.head.sampleB.id

    val durationA = vsSamples.map(s => s.sampleA.duration).sum
    val durationB = vsSamples.map(s => s.sampleB.duration).sum

    val ratio = if (durationA > durationB) {
      durationB.toDouble / durationA
    } else {
      durationA.toDouble / durationB
    }

    List(algNameA, algNameB, durationA, durationB, ratio).mkString(",")

  }

}
