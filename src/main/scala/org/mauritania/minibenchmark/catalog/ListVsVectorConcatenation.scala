package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class ListVsVectorConcatenation {

  @Benchmark
  def reduceList(): Int = {
    Range(1, seed).map(i => aList).reduce(_++_).size
  }

  @Benchmark
  def reduceVector(): Int = {
    Range(1, seed).map(i => aVector).reduce(_++_).size
  }

}

