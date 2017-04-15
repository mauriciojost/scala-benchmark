package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionConcatenation {

  @Benchmark
  def concatenateOnList(): Int = {
    Range(1, Seed).map(i => BaseList).reduce(_++_).size
  }

  @Benchmark
  def concatenateOnArray(): Int = {
    Range(1, Seed).map(i => BaseArray).reduce(_++_).size
  }

  @Benchmark
  def concatenateOnVector(): Int = {
    Range(1, Seed).map(i => BaseVector).reduce(_++_).size
  }

}


