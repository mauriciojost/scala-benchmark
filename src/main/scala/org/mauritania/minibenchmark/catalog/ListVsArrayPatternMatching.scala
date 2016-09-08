package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

object ListVsArrayPatternMatching extends Versus {

  val kL = Range(1, 500).toList
  val kA = Range(1, 500).toArray

  override val a = Algorithm("List to pattern match", fA)
  override val b = Algorithm("Array to pattern match", fB)

  private def fA(seed: Int): Int = {
    kL match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  private def fB(seed: Int): Int = {
    kA match {
      case Array(a, b, c, d, e, f, g, h, i, j, k, l, m, r@_*) => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

}




