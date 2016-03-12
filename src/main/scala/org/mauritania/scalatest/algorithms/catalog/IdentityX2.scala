package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object IdentityX2 extends Comparables {

  override def idA() = "identity0.5"

  override def fA(seed: Int): Int = fX(seed / 2)

  override def idB() = "identity1.0"

  override def fB(seed: Int): Int = fX(seed)

  private def fX(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}


