package org.mauritania.scalatest.result

case class Report (
  vsSamples : List[VsSample]
) {

  def printTable(): Unit = {

    val sep = "\t|\t"

    val saName = vsSamples.head.sampleA.id
    val sbName = vsSamples.head.sampleB.id

    println

    println(saName + sep + sbName)

    vsSamples.foreach { vsSample =>
      println(vsSample.sampleA.duration + sep + vsSample.sampleB.duration)
    }

    val sa = vsSamples.map(s => s.sampleA.duration).sum
    val sb = vsSamples.map(s => s.sampleB.duration).sum
    if (sa > sb) {
      println("\'" + sbName + "\' is faster than \'" + saName + "\': executed in " + ((sb * 100 / sa)) + "% of time")
    } else {
      println("\'" + saName + "\' is faster than \'" + sbName + "\': executed in " + ((sa * 100 / sb)) + "% of time")
    }

    println

  }
}
