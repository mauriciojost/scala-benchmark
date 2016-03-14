package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._
import org.mauritania.scalatest.result.Reports

object Starter {

  def main(args: Array[String]): Unit = {

    val reports = Reports(
      List(
        Comparator.testComparables(Identity, 500, 20000),
        Comparator.testComparables(IdentityX2, 500, 20000),
        Comparator.testComparables(TailRecursive, 500, 20000),
        Comparator.testComparables(SeqVsListSum, 50, 10000),
        Comparator.testComparables(ListVsVectorConcatenation, 10, 20000),
        Comparator.testComparables(ListVsArrayConcatenation, 10, 40000),
        Comparator.testComparables(ListVsArrayPatternMatching, 600, 40000),
        Comparator.testComparables(ListVsVectorPatternMatching, 600, 400000)
      )
    )

    reports.save()


  }


}
