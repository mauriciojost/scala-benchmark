package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object IdentityX4 extends Comparables {

  override val a = Algorithm("identity0.25", fX025)
  override val b = Algorithm("identity1.00", fX100)

  private def fX(seed: Int): Int = Range(1, seed).toList.sum
  private def fX025(seed: Int): Int = fX(seed / 4)
  private def fX100(seed: Int): Int = fX(seed)

}


