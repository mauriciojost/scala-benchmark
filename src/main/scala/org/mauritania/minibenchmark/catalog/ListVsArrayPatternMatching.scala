package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class ListVsArrayPatternMatching {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = Range(1, 500).toList

  @State(Scope.Benchmark)
  val anArray = Range(1, 500).toArray

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

}




