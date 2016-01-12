package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object MapOnCollections extends Comparables {

  def getFunctionA(): Algorithm = MCAlgorithmA

  def getFunctionB(): Algorithm = MCAlgorithmB

}

object MCAlgorithmA extends Algorithm {
  def description() = "Using List to iterate"

  def function(seed: Int): Int = {
    Range(1, seed).toList.sum
  }

}

object MCAlgorithmB extends Algorithm {

  def description() = "Using Seq to iterate"

  def function(seed: Int): Int = {
    Range(1, seed).toSeq.sum
  }

}

