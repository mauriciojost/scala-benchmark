package org.mauritania.scalatest.result

object FunctionBenchmark {

  def measure(f: (Int) => Int, id: String, seed: Int, nroIterations: Int): Sample = {
    // Warm up
    val durationWU = measureFunctionOneShot(f, seed)
    use(durationWU.toString)

    val results = Range(0, nroIterations).map { index =>
      measureFunctionOneShot(f, seed)
    }

    Sample(id, results.sum)

  }

  private def measureFunctionOneShot(function: (Int) => Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed)
    val end = System.nanoTime()
    end - begin
  }

  def use(a: Any) = if (a.toString.length < 0) println("-")

}
