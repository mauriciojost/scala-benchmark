package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object ListVsArrayConcatenation extends Comparables {

  val kL = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  val kA = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  override def idA() = "List to ++"

  override def fA(seed: Int): Int = {
    Range(1, seed).map(i => kL).reduce(_++_).size
  }

  override def idB() = "Array to ++"

  override def fB(seed: Int): Int = {
    Range(1, seed).map(i => kA).reduce(_++_).size
  }

}


