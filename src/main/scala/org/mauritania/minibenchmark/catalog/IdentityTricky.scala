package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class IdentityTricky {

  @Benchmark
  def identity(): Int = {
    LargeList.sum
  }

  @Benchmark
  def identitySame(): Int = {
    LargeList.sum
  }

  @Benchmark
  def identityBy2(): Int = {
    HalfLargeList.sum
  }

  @Benchmark
  def identityBy4(): Int = {
    QuarterLargeList.sum
  }

}


