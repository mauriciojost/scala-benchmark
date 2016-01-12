package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._

object Starter {

  def main(args: Array[String]): Unit = {
    Tester.testComparables(Identity, 5000, 100000)
    //Tester.testComparables(TailRecursive, 5000, 100000)
    //Tester.testComparables(MapOnCollections, 5000, 100000)
  }


}
