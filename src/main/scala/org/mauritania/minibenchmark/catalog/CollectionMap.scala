package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionMap {

  // See http://www.scala-lang.org/docu/files/collections-api/collections_40.html

  @Benchmark
  def mapOnList(): Int = {
    val k = BaseList
    k.map(_ + 1).map(_ + 2).map(_ + 3).sum
  }

  @Benchmark
  def mapOnVector(): Int = {
    val k = BaseVector
    k.map(_ + 1).map(_ + 2).map(_ + 3).sum
  }

}


