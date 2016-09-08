package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

class PartialFunctions extends Versus {

  override val a = Algorithm("PFU", fA)
  override val b = Algorithm("F&M", fB)

  private def fA(seed: Int): Int = {
    val div: PartialFunction[Int, Int] = {
      case k: Int if k%2 != 0 => 1 / k
    }
    val i = Range(-1, seed)
    i.collect(div).size
  }

  private def fB(seed: Int): Int = {
    val i = Range(-1, seed)
    i.filter(_ %2 != 0).map(1/_).size
  }

}

