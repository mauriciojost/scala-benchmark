package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

class ListVsVectorRandomAccess {

  @Benchmark
  def randomAccessOnList(): Int = {
    val k = aList.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

  @Benchmark
  def randomAccessOnVector(): Int = {
    val k = aVector.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

}


