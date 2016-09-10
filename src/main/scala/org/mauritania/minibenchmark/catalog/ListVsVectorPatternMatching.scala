package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class ListVsVectorPatternMatching {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = Range(1, 500).toList

  @State(Scope.Benchmark)
  val aVector = Range(1, 500).toVector

  @Benchmark
  def patternMatchingOnList(): Int = {
    aList match {
      case a :: b :: c :: d :: e :: f :: g :: h :: i :: j :: k :: l :: m :: x => a + c + seed
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


