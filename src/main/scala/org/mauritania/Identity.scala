package org.mauritania

import org.openjdk.jmh.annotations.Benchmark
import org.mauritania.Const.seed

class Identity {

  @Benchmark
  def identity1(): Int = {
    Range(1, seed).toList.sum
  }

  @Benchmark
  def identity2(): Int = {
    Range(1, seed).toList.sum
  }

}


