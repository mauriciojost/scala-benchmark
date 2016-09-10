package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class IdentityX2 {

  private def fX(p: Int): Int = Range(1, p).toList.sum

  @Benchmark
  def fX05(): Int = fX(seed / 2)

  @Benchmark
  def fX10(): Int = fX(seed)

}


