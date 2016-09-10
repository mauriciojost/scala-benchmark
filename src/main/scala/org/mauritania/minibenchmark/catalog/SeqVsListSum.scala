package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class SeqVsListSum {

  @State(Scope.Benchmark)
  val seed = 1000

  @State(Scope.Benchmark)
  val aList = Range(1, 1000).toList

  @State(Scope.Benchmark)
  val aSeq = Range(1, 1000).toSeq

  @Benchmark
  def sumOnList(): Int = {
    aList.sum
  }

  @Benchmark
  def sumOnSeq(): Int = {
    aSeq.sum
  }

}

