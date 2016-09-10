package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

class ListVsArrayConcatenation {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  @State(Scope.Benchmark)
  val anArray = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  @Benchmark
  def reduceOnList(): Int = {
    Range(1, seed).map(i => aList).reduce(_++_).size
  }

  @Benchmark
  def reduceOnArray(): Int = {
    Range(1, seed).map(i => anArray).reduce(_++_).size
  }

}


