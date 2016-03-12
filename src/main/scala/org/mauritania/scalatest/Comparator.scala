package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.Comparables
import org.mauritania.scalatest.result.{Report, VsSample, Sample}

object Comparator {

  def testComparables(alg: Comparables, seed: Int, iterations: Int) = {
    // General warm up
    use(measureFunctionManyShots(alg.fA, alg.idA(), seed, iterations).toString())
    use(measureFunctionManyShots(alg.fB, alg.idB(), seed, iterations).toString())
    use(measureFunctionManyShots(alg.fA, alg.idA(), seed, iterations).toString())
    use(measureFunctionManyShots(alg.fB, alg.idB(), seed, iterations).toString())

    val result1 = Range(0, 15).map { index =>
      val fa = measureFunctionManyShots(alg.fA, alg.idA, seed, iterations)
      val fb = measureFunctionManyShots(alg.fB, alg.idB, seed, iterations)
      VsSample(fa, fb)
    }

    use(measureFunctionManyShots(alg.fA, alg.idA(), seed, iterations).toString())

    val result2 = Range(0, 15).map { index =>
      val fb = measureFunctionManyShots(alg.fB, alg.idB, seed, iterations)
      val fa = measureFunctionManyShots(alg.fA, alg.idA, seed, iterations)
      VsSample(fa, fb)
    }

    Report((result1 ++ result2).toList)

  }

  def measureFunctionManyShots(f: Int => Int, id: String, seed: Int, iterations: Int) = {
    // Warm up
    val durationWU = measureFunctionOneShot(f, seed)
    use(durationWU.toString)

    val results = Range(0, iterations).map { index =>
      measureFunctionOneShot(f, seed)
    }

    Sample(id, results.sum)

  }

  private def measureFunctionOneShot(function: Int => Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed)
    val end = System.nanoTime()
    end - begin
  }

  private def use(a: String) = if (a.length > 1) print(".") else print("-")

}
