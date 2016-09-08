package org.mauritania.minibenchmark

import org.mauritania.minibenchmark.reporting.{Report, VersusSample}

object VersusBenchmark {

  def benchmarkInRange(c: Versus, seeds: Seq[Int], iterations: Int = 1000): Seq[Report] = {
    seeds.map { seed =>
      benchmark(c, seed, iterations)
    }
  }

  def benchmark(c: Versus, seed: Int = 10, iterations: Int = 1000): Report = {

    val algoA = c.a
    val alboB = c.b

    // General warm up
    AlgorithmBenchmark.measure(algoA.f, algoA.id, seed, iterations)
    AlgorithmBenchmark.measure(alboB.f, alboB.id, seed, iterations)
    AlgorithmBenchmark.measure(algoA.f, algoA.id, seed, iterations)
    AlgorithmBenchmark.measure(alboB.f, alboB.id, seed, iterations)

    val result1 = Range(0, 15).map { index =>
      val fa = AlgorithmBenchmark.measure(algoA.f, algoA.id, seed, iterations)
      val fb = AlgorithmBenchmark.measure(alboB.f, alboB.id, seed, iterations)
      VersusSample(fa, fb)
    }

    AlgorithmBenchmark.measure(algoA.f, algoA.id, seed, iterations)

    val result2 = Range(0, 15).map { index =>
      val fb = AlgorithmBenchmark.measure(alboB.f, alboB.id, seed, iterations)
      val fa = AlgorithmBenchmark.measure(algoA.f, algoA.id, seed, iterations)
      VersusSample(fa, fb)
    }

    Report(result1 ++ result2, seed)

  }

}
