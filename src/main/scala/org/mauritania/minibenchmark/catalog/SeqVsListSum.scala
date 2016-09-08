package org.mauritania.minibenchmark.catalog

import org.mauritania.minibenchmark.{Algorithm, Versus}

object SeqVsListSum extends Versus {

  val l = Range(1, 1000).toList
  val s = Range(1, 1000).toSeq

  override val a = Algorithm("List to sum", fA)
  override val b = Algorithm("Seq to sum", fB)

  private def fA(seed: Int): Int = {
    l.sum
  }

  private def fB(seed: Int): Int = {
    s.sum
  }

}

