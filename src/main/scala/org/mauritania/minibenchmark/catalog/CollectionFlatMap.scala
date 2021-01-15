package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionFlatMap {

  // See http://www.scala-lang.org/docu/files/collections-api/collections_40.html

  @Benchmark
  def flatMapOnList(): Int = {
    val k = BaseList
    k.flatMap(i => if (i%2==0) List(i) else List(i, i, i)).sum
  }

  @Benchmark
  def flatMapOnVector(): Int = {
    val k = BaseVector
    k.flatMap(i => if (i%2==0) Vector(i) else Vector(i, i, i)).sum
  }

}


