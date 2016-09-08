package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

object IdentityX2 extends Versus {

  override val a = Algorithm("identity0.5", fX05)
  override val b = Algorithm("identity1.0", fX10)

  private def fX(seed: Int): Int = Range(1, seed).toList.sum
  private def fX05(seed: Int): Int = fX(seed / 2)
  private def fX10(seed: Int): Int = fX(seed)

}


