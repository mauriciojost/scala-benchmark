package org.mauritania.minibenchmark

import java.lang.management.ManagementFactory

import scala.collection.JavaConverters._

object GCR {

  private def reportGC: Unit = {
    val mxbeans = ManagementFactory.getGarbageCollectorMXBeans().iterator().asScala
    val count = mxbeans.map(b => b.getCollectionCount).sum
    val time = mxbeans.map(b => b.getCollectionTime).sum
    println(count + " " + time)
  }

  def testComparables(c: Versus, seed: Int = 0, iterations: Int = 1000) = {

    val a = c.a
    val b = c.b

    // General warm up
    reportGC
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    reportGC
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    AlgorithmBenchmark.measure(a.f, a.id, seed, iterations)
    reportGC

  }

}
