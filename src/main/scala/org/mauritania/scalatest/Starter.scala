package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.TailRecursive

object Starter {

  def main(args: Array[String]): Unit = {
    println(Tester.test(TailRecursive.getFunctionA()))
    println(Tester.test(TailRecursive.getFunctionB()))

    println(Tester.test(TailRecursive.getFunctionA()))
    println(Tester.test(TailRecursive.getFunctionB()))

    println(Tester.test(TailRecursive.getFunctionA()))
    println(Tester.test(TailRecursive.getFunctionB()))
  }

}
