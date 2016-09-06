package org.mauritania.scalatest


import org.mauritania.scalatest.algorithms.Comparables
import org.mauritania.scalatest.result.{Report, Sample, VsSample}

object Comparator {

  def testComparables(alg: Comparables, seed: Int, iterations: Int, parameter: Int = 1) = {

    val a = alg.a
    val b = alg.b

    // General warm up
    use(measureFunctionManyShots(a.f, a.id, parameter, seed, iterations).toString())
    use(measureFunctionManyShots(b.f, b.id, parameter, seed, iterations).toString())
    use(measureFunctionManyShots(a.f, a.id, parameter, seed, iterations).toString())
    use(measureFunctionManyShots(b.f, b.id, parameter, seed, iterations).toString())

    val result1 = Range(0, 15).map { index =>
      val fa = measureFunctionManyShots(a.f, a.id, parameter, seed, iterations)
      val fb = measureFunctionManyShots(b.f, b.id, parameter, seed, iterations)
      VsSample(fa, fb)
    }

    use(measureFunctionManyShots(a.f, a.id, parameter, seed, iterations).toString())

    val result2 = Range(0, 15).map { index =>
      val fb = measureFunctionManyShots(b.f, b.id, parameter, seed, iterations)
      val fa = measureFunctionManyShots(a.f, a.id, parameter, seed, iterations)
      VsSample(fa, fb)
    }

    Report((result1 ++ result2).toList)

  }

  def measureFunctionManyShots(f: (Int, Int) => Int, id: String, parameter: Int, seed: Int, nroIterations: Int) = {
    // Warm up
    val durationWU = measureFunctionOneShot(f, parameter, seed)
    use(durationWU.toString)

    val results = Range(0, nroIterations).map { index =>
      measureFunctionOneShot(f, parameter, seed)
    }

    Sample(id, results.sum)

  }

  private def measureFunctionOneShot(function: (Int, Int) => Int, parameter: Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed, parameter)
    val end = System.nanoTime()
    end - begin
  }

  private def use(a: String) = if (a.length > 1) print(".") else print("-")

}
