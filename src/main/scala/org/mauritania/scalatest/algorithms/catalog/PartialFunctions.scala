package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object PartialFunctions extends Comparables {

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

