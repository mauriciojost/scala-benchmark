package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._

object Starter {

  def main(args: Array[String]): Unit = {

    Comparator.testComparables(Identity, 1000, 20000).printTable()
    Comparator.testComparables(Identity, 1000, 20000).printTable()
    //Comparator.testComparables(TailRecursive, 500, 20000).printTable()
    //Comparator.testComparables(MapOnCollections, 50, 100).printTable()
    //Comparator.testComparables(ListVsVectorConcatenation, 500, 100).printTable()
    //Comparator.testComparables(ListVsArrayConcatenation, 200, 400).printTable()
    //Comparator.testComparables(ListVsArrayPatternMatching, 600, 10000).printTable()
    //Comparator.testComparables(ListVsVectorPatternMatching, 600, 100000).printTable()


  }


}
