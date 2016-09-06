package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

import scala.annotation.tailrec

object TailRecursive extends Comparables {

  override val a = Algorithm("Head recursion", fA)
  override val b = Algorithm("Tail recursion", fB)

  private def fA(seed: Int, i: Int): Int = {
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

  private def fB(seed: Int, i: Int): Int = {
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

