package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.Benchmark
import org.mauritania.mauritania._

class PatternMatchingOnCharSO37896511 {

  @Benchmark
  def withPatternMatch(): Int = {
    LargeCharArray.map { aChar =>
      aChar match {
        case 'C' => 1
        case _ => 0
      }
    }.sum
  }

  @Benchmark
  def withoutPatternMatch(): Int = {
    LargeCharArray.map { aChar =>
      (aChar == 'C') match {
        case true => 1
        case false => 0
      }
    }.sum
  }

}
