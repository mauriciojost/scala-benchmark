package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.{Comparables, Algorithm}
import org.mauritania.scalatest.result.{VsSample, Sample}

object Tester {

  def testComparables(alg: Comparables, seed: Int, iterations: Int) = {
    // General warm up
    use(measureFunctionManyShots(alg.getFunctionA(), seed, iterations).toString())
    use(measureFunctionManyShots(alg.getFunctionB(), seed, iterations).toString())

    val result = Range(0, 10).map { index =>
      val fa = measureFunctionManyShots(alg.getFunctionA(), seed, iterations)
      val fb = measureFunctionManyShots(alg.getFunctionB(), seed, iterations)
      VsSample(fa, fb)
    }

    result.toList

  }

  def measureFunctionManyShots(f: Algorithm, seed: Int, iterations: Int) = {
    // Warm up
    val durationWU = measureFunctionOneShot(f.function, seed)
    use(durationWU.toString)

    val results = Range(0, iterations).map { index =>
      measureFunctionOneShot(f.function, seed)
    }

    Sample(f.description(), results.sum)

  }

  private def measureFunctionOneShot(function: Int => Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed)
    val end = System.nanoTime()
    end - begin
  }

  private def use(a: String) = if (a.length > 1) println(".") else println("-")


}
