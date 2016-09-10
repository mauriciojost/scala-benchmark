package org.mauritania.minibenchmark.catalog

import org.openjdk.jmh.annotations.{Scope, Benchmark, State}

import scala.annotation.tailrec

class TailRecursive {

  @State(Scope.Benchmark)
  val seed = 1000

  @Benchmark
  def headRecursion(): Int = {
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

  @Benchmark
  def tailRecursion(): Int = {
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

