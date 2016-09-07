package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._
import org.mauritania.scalatest.result.Reports

object StarterAll {

  def main(args: Array[String]): Unit = {

    val iterationsFactor = 1

    val reports = Reports(
      List(
        Comparator.testComparables(Identity, 500, 200 * iterationsFactor),
        Comparator.testComparables(IdentityX2, 500, 200 * iterationsFactor),
        Comparator.testComparables(IdentityX4, 500, 200 * iterationsFactor),
        Comparator.testComparables(TailRecursive, 500, 200 * iterationsFactor),
        Comparator.testComparables(SeqVsListSum, 50, 100 * iterationsFactor),
        Comparator.testComparables(ListVsVectorConcatenation, 10, 200 * iterationsFactor),
        Comparator.testComparables(ListVsArrayConcatenation, 10, 400 * iterationsFactor),
        Comparator.testComparables(ListVsArrayPatternMatching, 600, 400 * iterationsFactor),
        Comparator.testComparables(ListVsVectorPatternMatching, 600, 4000 * iterationsFactor),
        Comparator.testComparables(ListVsVectorRandomAccess, 200, 4000 * iterationsFactor),
        Comparator.testComparables(PartialFunctions, 500000, 1 * iterationsFactor)
      )
    )

    reports.save()

  }


}
