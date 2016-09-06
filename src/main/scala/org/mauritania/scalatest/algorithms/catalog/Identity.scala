package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object Identity extends Comparables {

  val a = Algorithm("identity1", fX)
  val b = Algorithm("identity2", fX)

  private def fX(seed: Int, i: Int): Int = {
    Range(1, seed).toList.sum
  }

}


