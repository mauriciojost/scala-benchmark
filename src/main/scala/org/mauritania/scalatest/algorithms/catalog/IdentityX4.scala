package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object IdentityX4 extends Comparables {

  override def idA() = "identity0.25"

  override def fA(seed: Int): Int = fX(seed / 4)

  override def idB() = "identity1.00"

  override def fB(seed: Int): Int = fX(seed)

  private def fX(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}


