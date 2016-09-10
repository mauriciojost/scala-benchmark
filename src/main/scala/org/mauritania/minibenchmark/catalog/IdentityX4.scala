package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class IdentityX4 {

  private def fX(seed: Int): Int = Range(1, seed).toList.sum

  @Benchmark
  def fX025(): Int = fX(seed / 4)

  @Benchmark
  def fX100(): Int = fX(seed)

}


