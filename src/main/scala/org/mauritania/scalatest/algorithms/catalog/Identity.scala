package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object Identity extends Comparables {

  override def idA() = "identity1"

  override def fA(seed: Int): Int = fX(seed)

  override def idB() = "identity2"

  override def fB(seed: Int): Int = fX(seed)

  private def fX(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}


