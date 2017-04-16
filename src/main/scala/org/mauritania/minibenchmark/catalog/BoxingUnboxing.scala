package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class BoxingUnboxing {

  // http://stackoverflow.com/questions/4899092/scala-performance-question

  @Benchmark
  def noBoxing(): Int = {
    Range(1, Seed).collect { case e if (e * 2 > 10) => e * 2 }.sum
  }

  @Benchmark
  def withBoxing(): Int = {
    Range(1, Seed).map(e => e * 2).filter(e => e > 10).sum
  }

}


