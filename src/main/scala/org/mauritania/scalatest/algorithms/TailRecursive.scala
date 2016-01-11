package org.mauritania.scalatest.algorithms

object TailRecursive extends ComparableAlgorithms {

  def getFunctionA(): Algorithm = AlgorithmA

  def getFunctionB(): Algorithm = AlgorithmB

}

object AlgorithmA extends Algorithm {
  def description() = "Without using tail recursion"

  def function(seed: Int): Int = {
    val range = Range(1, seed).toList
    def sum(acum: Int, values: Seq[Int]): Int = {
      values match {
        case Nil => 0
        case a :: Nil => a
        case a :: b :: rest => sum(a + b, rest)
      }
    }
    sum(0, range)
  }

}

object AlgorithmB extends Algorithm {

  def description() = "Using tail recursion"

  def function(seed: Int): Int = {
    val range = Range(1, seed).toList
    def sum(acum: Int, values: Seq[Int]): Int = {
      values match {
        case Nil => 0
        case a :: Nil => a
        case a :: b :: rest => sum(a + b, rest)
      }
    }
    sum(0, range)
  }

}

