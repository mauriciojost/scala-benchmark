package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.{Comparables, Algorithm}

object Tester {

  def testComparables(alg: Comparables, seed: Int, iterations: Int): Unit = {
    use(measureFunctionManyShots(alg.getFunctionA(), seed, iterations).toString())
    use(measureFunctionManyShots(alg.getFunctionB(), seed, iterations).toString())

    println(measureFunctionManyShots(alg.getFunctionA(), seed, iterations))
    println(measureFunctionManyShots(alg.getFunctionB(), seed, iterations))

    println(measureFunctionManyShots(alg.getFunctionA(), seed, iterations))
    println(measureFunctionManyShots(alg.getFunctionB(), seed, iterations))

  }

  def measureFunctionManyShots(f: Algorithm, seed: Int, iterations: Int) = {
    // Warm up
    val durationWU = measureFunctionOneShot(f.function, seed)
    use(durationWU.toString)

    val results = Range(0, iterations).map { index =>
      measureFunctionOneShot(f.function, seed)
    }

    (f.description(), results.sum)

  }

  private def measureFunctionOneShot(function: Int => Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed)
    val end = System.nanoTime()
    end - begin
  }

  private def use(a: String) = if (a.length > 1) println(".") else println("-")


}
