package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

class PartialFunctions {

  @State(Scope.Benchmark)
  val seed = 1000

  @Benchmark
  def partialFunction(): Int = {
    val div: PartialFunction[Int, Int] = {
      case k: Int if k%2 != 0 => 1 / k
    }
    val i = Range(-1, seed)
    i.collect(div).size
  }

  @Benchmark
  def filterAndMap(): Int = {
    val i = Range(-1, seed)
    i.filter(_ %2 != 0).map(1/_).size
  }

}

