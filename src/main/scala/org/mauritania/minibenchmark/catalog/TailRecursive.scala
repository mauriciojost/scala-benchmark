package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

import scala.annotation.tailrec

object TailRecursive extends Versus {

  override val a = Algorithm("Head recursion", fA)
  override val b = Algorithm("Tail recursion", fB)

  private def fA(seed: Int): Int = {
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

  private def fB(seed: Int): Int = {
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

