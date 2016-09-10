package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class ListVsVectorRandomAccess {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = Range(1, 1000).toList

  @State(Scope.Benchmark)
  val aVector = Range(1, 1000).toVector

  @Benchmark
  def randomAccessOnList(): Int = {
    val k = aList.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

  @Benchmark
  def randomAccessOnVector(): Int = {
    val k = aVector.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

}


