package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class CollectionConcatenation {

  @Benchmark
  def concatenateOnList(): Int = {
    Range(1, seed).map(i => aList).reduce(_++_).size
  }

  @Benchmark
  def concatenateOnArray(): Int = {
    Range(1, seed).map(i => anArray).reduce(_++_).size
  }

  @Benchmark
  def concatenateOnVector(): Int = {
    Range(1, seed).map(i => aVector).reduce(_++_).size
  }

}


