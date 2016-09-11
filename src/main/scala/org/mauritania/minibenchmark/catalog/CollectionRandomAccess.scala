package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionRandomAccess {

  @Benchmark
  def randomAccessOnArray(): Int = {
    val k = anArray
    k(7) + k(1) + k(8) + k(k(1)) + k(5) + k(9) + k(4)
  }

  @Benchmark
  def randomAccessOnList(): Int = {
    val k = aList
    k(7) + k(1) + k(8) + k(k(1)) + k(5) + k(9) + k(4)
  }

  @Benchmark
  def randomAccessOnVector(): Int = {
    val k = aVector
    k(7) + k(1) + k(8) + k((k(1))) + k(5) + k(9) + k(4)
  }

}


