package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

class Identity {

  @State(Scope.Benchmark)
  val seed = 1000

  @Benchmark
  def identity1(): Int = {
    Range(1, seed).toList.sum
  }

  @Benchmark
  def identity2(): Int = {
    Range(1, seed).toList.sum
  }

}


