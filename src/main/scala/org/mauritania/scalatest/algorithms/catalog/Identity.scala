package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object Identity extends Comparables {

  def getFunctionA(): Algorithm = IAlgorithmAB

  def getFunctionB(): Algorithm = IAlgorithmAB

}

object IAlgorithmAB extends Algorithm {
  def description() = "The same algorithm used twice"

  def function(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}


