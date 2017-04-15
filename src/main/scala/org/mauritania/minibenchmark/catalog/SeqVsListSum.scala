package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class SeqVsListSum {

  @Benchmark
  def sumOnList(): Int = {
    BaseList.sum
  }

  @Benchmark
  def sumOnSeq(): Int = {
    BaseSeq.sum
  }

}

