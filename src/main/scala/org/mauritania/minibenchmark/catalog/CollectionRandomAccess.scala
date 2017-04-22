package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionRandomAccess {

  // See http://www.scala-lang.org/docu/files/collections-api/collections_40.html

  @Benchmark
  def randomAccessOnArray(): Int = {
    val k = BaseArray
    k(7) + k(1) + k(8) + k(k(1)) + k(5) + k(9) + k(4)
  }

  @Benchmark
  def randomAccessOnList(): Int = {
    val k = BaseList
    k(7) + k(1) + k(8) + k(k(1)) + k(5) + k(9) + k(4)
  }

  @Benchmark
  def randomAccessOnVector(): Int = {
    val k = BaseVector
    k(7) + k(1) + k(8) + k((k(1))) + k(5) + k(9) + k(4)
  }

}


