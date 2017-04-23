package org.mauritania.minibenchmark.catalog

import org.mauritania.mauritania._
import org.openjdk.jmh.annotations.Benchmark

/**
  * This example aims to show that the creation of the state variables
  * is not measured by the benchmark itself,
  * How?
  * - Two very different sized lists are equal'd
  * - The .equals does not depend on their size
  * - If the benchmark measured the creation of the List too, it would differ substantially
  * - However the benchmark results in similar metrics
  */
class StateVariable {

  @Benchmark
  def list(): Int = {
    if (LargeList.equals(None)) 0 else 1
  }

  @Benchmark
  def quarterList(): Int = {
    if (QuarterLargeList.equals(None)) 0 else 1
  }

}


