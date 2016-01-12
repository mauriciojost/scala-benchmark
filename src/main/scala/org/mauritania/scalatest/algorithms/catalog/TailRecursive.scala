package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

import scala.annotation.tailrec

object TailRecursive extends Comparables {

  def getFunctionA(): Algorithm = AlgorithmA

  def getFunctionB(): Algorithm = AlgorithmB

}

object AlgorithmA extends Algorithm {
  def description() = "Using head recursion (recursive call and then some calculation)"

  def function(seed: Int): Int = {
    val range = Range(1, seed).toList
    def sum(values: Seq[Int]): Int = {
      values match {
        case Nil => 0
        case a :: Nil => a
        case a :: rest => a + sum(rest)
      }
    }
    sum(range)
  }

}

object AlgorithmB extends Algorithm {

  def description() = "Using tail recursion (some calculation and then recursive call)"

  def function(seed: Int): Int = {
    val range = Range(1, seed).toList
    @tailrec
    def sum(acum: Int, values: List[Int]): Int = {
      values match {
        case Nil => 0
        case a :: Nil => a
        case a :: b :: rest => sum(a + b, rest)
      }
    }
    sum(0, range)
  }

}

