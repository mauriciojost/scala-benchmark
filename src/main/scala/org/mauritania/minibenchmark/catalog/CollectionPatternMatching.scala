package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionPatternMatching {

  @Benchmark
  def patternMatchOnList(): Int = {
    aList match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  @Benchmark
  def patternMatchOnArray(): Int = {
    anArray match {
      case Array(a, b, c, d, e, f, g, h, i, j, k, l, m, r@_*) => a + c + seed
      case _ => throw new RuntimeException()
    }
  }

  @Benchmark
  def patternMatchingOnVector(): Int = {
    aVector match {
      case a +: b +: c +: d +: e +: f +: g +: h +: i +: j +: k +: l +: m +: x => a + c + seed
      case _ => throw new RuntimeException()
    }
  }


}




