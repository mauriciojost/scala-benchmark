package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._
import org.mauritania.scalatest.result.VsSample

object Starter {

  def printTable(r: List[VsSample]): Unit = {
    println(r.head.sampleA.id + "\t" + r.head.sampleB.id)
    r.foreach(s => println(s.sampleA.duration + "\t" + s.sampleB.duration))
  }

  def main(args: Array[String]): Unit = {
    //val r = Tester.testComparables(Identity, 5000, 100000)
    //val r = Tester.testComparables(TailRecursive, 5000, 100000)
    //val r = Tester.testComparables(MapOnCollections, 5000, 100000)
    val r = Tester.testComparables(ListVsVector, 50, 400)

    printTable(r)
  }


}
