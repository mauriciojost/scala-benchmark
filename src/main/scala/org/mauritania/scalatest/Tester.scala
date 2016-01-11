package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.Algorithm

object Tester {

  val Executions = 5000

  val SeedInt = 100000

  def test(f: Algorithm) = {
    // Warm up
    val durationWU = measure(f.function)
    use(durationWU)

    val iterations = Range(0, Executions).map { index =>
      measure(f.function)
    }

    (f.description(), iterations.sum)

  }

  private def measure(function: Int => Int): Long = {
    val begin = System.currentTimeMillis()
    function(SeedInt)
    val end = System.currentTimeMillis()
    end - begin
  }

  private def use(a: Long) = {
    if (a > 0)
      println(".")
    else
      println("-")
  }

}
