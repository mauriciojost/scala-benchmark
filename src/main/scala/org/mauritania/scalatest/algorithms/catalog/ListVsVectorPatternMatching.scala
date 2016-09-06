package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object ListVsVectorPatternMatching extends Comparables {

  val kL = Range(1, 500).toList
  val kV = Range(1, 500).toVector

  override val a = Algorithm("List for pattern matching", fA)
  override val b = Algorithm("Vector for pattern matching", fB)

  private def fA(seed: Int, i: Int): Int = {
    kL match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  private def fB(seed: Int, i: Int): Int = {
    kV match {
      case a +: b +: c +: d +: e +: f +: g +: h +: i +: j +: k +: l +: m +: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

}


