package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionIterationIntermediate {

  @Benchmark
  def withIntermediateCollections(): Int = {
    LargeList.
      map(i => i + 1).
      map(i => i * 2).
      sum
  }

  @Benchmark
  def withoutIntermediateCollections(): Int = {
    LargeList.
      view.
      map(i => i + 1).
      map(i => i * 2).
      force.
      sum
  }

}
