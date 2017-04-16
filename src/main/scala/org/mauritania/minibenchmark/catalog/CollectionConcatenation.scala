package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionConcatenation {

  @Benchmark
  def concatenateOnList(): Int = {
    ARange.map(i => BaseList).reduce(_++_).sum
  }

  @Benchmark
  def concatenateOnArray(): Int = {
    ARange.map(i => BaseArray).reduce(_++_).sum
  }

  @Benchmark
  def concatenateOnVector(): Int = {
    ARange.map(i => BaseVector).reduce(_++_).sum
  }

}


