package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._

object StarterSingle {

  def main(args: Array[String]): Unit = {

    val iterationsFactor = 200
    val comp = PartialFunctions

    println(Comparator.testComparables(comp, 10, 1 * iterationsFactor).generateResultLine())
    println(Comparator.testComparables(comp, 1000, 1 * iterationsFactor).generateResultLine())
    println(Comparator.testComparables(comp, 10000, 1 * iterationsFactor).generateResultLine())
    println(Comparator.testComparables(comp, 100000, 1 * iterationsFactor).generateResultLine())
    println(Comparator.testComparables(comp, 1000000, 1 * iterationsFactor).generateResultLine())

    //GCR.testComparables(PartialFunctions, 10000, 10000)


  }


}
