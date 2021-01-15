package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionMap2 {

  // See http://www.scala-lang.org/docu/files/collections-api/collections_40.html

  @Benchmark
  def mapOnListViewForce(): Int = {
    val k = BaseList
    k.view.map(_ + 1).map(_ + 2).map(_ + 3).force.sum
  }

  @Benchmark
  def mapOnVectorViewForce(): Int = {
    val k = BaseVector
    k.view.map(_ + 1).map(_ + 2).map(_ + 3).force.sum
  }

}


