package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object ListVsVectorPatternMatching extends Comparables {

  val kL = Range(1, 500).toList
  val kV = Range(1, 500).toVector

  override def idA() = "List for pattern matching"

  override def fA(seed: Int): Int = {
    kL match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  override def idB() = "Vector for pattern matching"

  override def fB(seed: Int): Int = {
    kV match {
      case a +: b +: c +: d +: e +: f +: g +: h +: i +: j +: k +: l +: m +: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

}


