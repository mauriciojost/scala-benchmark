package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class ListVsVectorConcatenation {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  @State(Scope.Benchmark)
  val aVector = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  @Benchmark
  def reduceList(): Int = {
    Range(1, seed).map(i => aList).reduce(_++_).size
  }

  @Benchmark
  def reduceVector(): Int = {
    Range(1, seed).map(i => aVector).reduce(_++_).size
  }

}

