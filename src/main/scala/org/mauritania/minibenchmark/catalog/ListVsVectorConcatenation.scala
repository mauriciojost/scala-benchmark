package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

object ListVsVectorConcatenation extends Versus {

  val kL = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  val kV = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  override val a = Algorithm("List to ++", fA)
  override val b = Algorithm("Vector to ++", fB)

  private def fA(seed: Int): Int = {
    Range(1, seed).map(i => kL).reduce(_++_).size
  }

  private def fB(seed: Int): Int = {
    Range(1, seed).map(i => kV).reduce(_++_).size
  }

}

