package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

object IdentityX4 extends Versus {

  override val a = Algorithm("identity0.25", fX025)
  override val b = Algorithm("identity1.00", fX100)

  private def fX(seed: Int): Int = Range(1, seed).toList.sum
  private def fX025(seed: Int): Int = fX(seed / 4)
  private def fX100(seed: Int): Int = fX(seed)

}


