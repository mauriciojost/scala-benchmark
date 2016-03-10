package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object ListVsVector extends Comparables {

  def getFunctionA(): Algorithm = MCAlgorithmA

  def getFunctionB(): Algorithm = MCAlgorithmB

}

object MCAlgorithmA extends Algorithm {

  val k = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  def description() = "List"

  def function(seed: Int): Int = {
    Range(1, seed).map(i => k).reduce(_++_).size
  }

}

object MCAlgorithmB extends Algorithm {

  val k = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  def description() = "Vector"

  def function(seed: Int): Int = {
    Range(1, seed).map(i => k).reduce(_++_).size
  }

}

