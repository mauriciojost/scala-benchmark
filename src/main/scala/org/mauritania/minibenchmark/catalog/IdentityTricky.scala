package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class IdentityTricky {

  @Benchmark
  def identity(): Int = {
    Range(1, Seed).sum
  }

  @Benchmark
  def identitySame(): Int = {
    Range(1, Seed).sum
  }

  @Benchmark
  def identityBy2(): Int = {
    Range(1, Seed/2).sum
  }

}


