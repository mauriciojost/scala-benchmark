package org.mauritania.minibenchmark

import org.mauritania.minibenchmark.reporting.AlgorithmSample

object AlgorithmBenchmark {

  def measure(f: (Int) => Int, id: String, seed: Int, nroIterations: Int): AlgorithmSample = {
    // Warm up
    measureFunctionOneShot(f, seed)

    // Sampling
    val results = Range(0, nroIterations).map { index =>
      measureFunctionOneShot(f, seed)
    }

    // The end
    AlgorithmSample(id, results.sum)

  }

  private def measureFunctionOneShot(function: (Int) => Int, seed: Int): Long = {
    val begin = System.nanoTime()
    function(seed)
    val end = System.nanoTime()
    end - begin
  }

}
