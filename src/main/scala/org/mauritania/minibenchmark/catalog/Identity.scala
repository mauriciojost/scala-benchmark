package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

class Identity extends Versus {

  val a = Algorithm("identity1", fX)
  val b = Algorithm("identity2", fX)

  private def fX(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}


