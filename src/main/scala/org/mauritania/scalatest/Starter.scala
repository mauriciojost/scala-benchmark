package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog.TailRecursive

object Starter {

  def main(args: Array[String]): Unit = {
    Tester.testComparables(TailRecursive, 5000, 100000)
  }


}
