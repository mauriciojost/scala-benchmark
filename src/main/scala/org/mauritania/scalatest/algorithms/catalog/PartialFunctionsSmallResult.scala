package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object PartialFunctionsSmallResult extends Comparables {

  override val a = Algorithm("Partial function", fA)
  override val b = Algorithm("Filter and map", fB)

  private def fA(seed: Int, i: Int): Int = {
    val div: PartialFunction[Int, Int] = {
      case k: Int if k%2 != 0 => 1 / k
    }
    val i = Range(-1, seed)
    i.collect(div).size
  }

  private def fB(seed: Int, i: Int): Int = {
    val i = Range(-1, seed)
    i.filter(_ %2 != 0).map(1/_).size
  }

}

