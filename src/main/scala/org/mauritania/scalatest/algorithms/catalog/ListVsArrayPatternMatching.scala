package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object ListVsArrayPatternMatching extends Comparables {

  val kL = Range(1, 500).toList
  val kA = Range(1, 500).toArray

  override def idA() = "List to pattern match"

  override def fA(seed: Int): Int = {
    kL match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  override def idB() = "Array to pattern match"

  override def fB(seed: Int): Int = {
    kA match {
      case Array(a, b, c, d, e, f, g, h, i, j, k, l, m, r@_*) => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

}




