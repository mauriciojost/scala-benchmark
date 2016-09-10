package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

class IdentityX4 {

  @State(Scope.Benchmark)
  val seed = 1000

  private def fX(seed: Int): Int = Range(1, seed).toList.sum

  @Benchmark
  def fX025(): Int = fX(seed / 4)

  @Benchmark
  def fX100(): Int = fX(seed)

}


