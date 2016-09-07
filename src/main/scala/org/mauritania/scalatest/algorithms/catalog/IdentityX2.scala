package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object IdentityX2 extends Comparables {

  override val a = Algorithm("identity0.5", fX05)
  override val b = Algorithm("identity1.0", fX10)

  private def fX(seed: Int): Int = Range(1, seed).toList.sum
  private def fX05(seed: Int): Int = fX(seed / 2)
  private def fX10(seed: Int): Int = fX(seed)

}


