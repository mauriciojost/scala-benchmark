package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class ListVsArrayConcatenation {

  @Benchmark
  def reduceOnList(): Int = {
    Range(1, seed).map(i => aList).reduce(_++_).size
  }

  @Benchmark
  def reduceOnArray(): Int = {
    Range(1, seed).map(i => anArray).reduce(_++_).size
  }

}


