package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog._

object Starter {

  def main(args: Array[String]): Unit = {

    Comparator.testComparables(Identity, 500, 20000).printTable().printConclusion().save()
    Comparator.testComparables(IdentityX2, 500, 20000).printTable().printConclusion().save()
    Comparator.testComparables(TailRecursive, 500, 20000).printTable().printConclusion().save()
    Comparator.testComparables(SeqVsListSum, 50, 10000).printTable().printConclusion().save()
    Comparator.testComparables(ListVsVectorConcatenation, 10, 20000).printTable().printConclusion().save()
    Comparator.testComparables(ListVsArrayConcatenation, 10, 40000).printTable().printConclusion().save()
    Comparator.testComparables(ListVsArrayPatternMatching, 600, 40000).printTable().printConclusion().save()
    Comparator.testComparables(ListVsVectorPatternMatching, 600, 400000).printTable().printConclusion().save()


  }


}
