package org.mauritania.scalatest


import org.mauritania.scalatest.algorithms.Comparables
import org.mauritania.scalatest.result.{Report, FunctionBenchmark, VsSample}

object Comparator {

  def testComparablesInrange(c: Comparables, seeds: Seq[Int], iterations: Int = 1000): Seq[Report] = {
    seeds.map { seed =>
      testComparables(c, seed, iterations)
    }
  }

  def testComparables(c: Comparables, seed: Int = 0, iterations: Int = 1000): Report = {

    val a = c.a
    val b = c.b

    // General warm up
    FunctionBenchmark.measure(a.f, a.id, seed, iterations)
    FunctionBenchmark.measure(b.f, b.id, seed, iterations)
    FunctionBenchmark.measure(a.f, a.id, seed, iterations)
    FunctionBenchmark.measure(b.f, b.id, seed, iterations)

    val result1 = Range(0, 15).map { index =>
      val fa = FunctionBenchmark.measure(a.f, a.id, seed, iterations)
      val fb = FunctionBenchmark.measure(b.f, b.id, seed, iterations)
      VsSample(fa, fb)
    }

    FunctionBenchmark.measure(a.f, a.id, seed, iterations)

    val result2 = Range(0, 15).map { index =>
      val fb = FunctionBenchmark.measure(b.f, b.id, seed, iterations)
      val fa = FunctionBenchmark.measure(a.f, a.id, seed, iterations)
      VsSample(fa, fb)
    }

    Report((result1 ++ result2).toList, seed)

  }

}
