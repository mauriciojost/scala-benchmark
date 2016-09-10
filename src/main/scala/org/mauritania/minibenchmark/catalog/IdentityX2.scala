package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

class IdentityX2 {

  @State(Scope.Benchmark)
  val seed = 1000

  private def fX(p: Int): Int = Range(1, p).toList.sum

  @Benchmark
  def fX05(): Int = fX(seed / 2)

  @Benchmark
  def fX10(): Int = fX(seed)

}


