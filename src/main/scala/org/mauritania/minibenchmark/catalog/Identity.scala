package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class Identity {

  @Benchmark
  def identity(): Int = {
    Range(1, seed).toList.sum
  }

  @Benchmark
  def identitySame(): Int = {
    Range(1, seed).toList.sum
  }

  @Benchmark
  def identityBy2(): Int = {
    Range(1, seed / 2).toList.sum
  }

  @Benchmark
  def identityBy4(): Int = {
    Range(1, seed / 4).toList.sum
  }

}


