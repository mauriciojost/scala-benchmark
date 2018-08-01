package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class IfVsPatternMatching {

  @Benchmark
  def ifs(): Int = {
    LargeArray.map{ v =>
      if (v % 2 == 0) 1 else 0
    }.sum
  }

  @Benchmark
  def patternMatchings(): Int = {
    LargeArray.map{ v =>
      (v % 2 == 0) match {
        case true => 1
        case false => 0
      }
    }.sum
  }

}

