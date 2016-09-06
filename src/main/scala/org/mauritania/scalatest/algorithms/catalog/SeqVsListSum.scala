package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object SeqVsListSum extends Comparables {

  val l = Range(1, 1000).toList
  val s = Range(1, 1000).toSeq

  override val a = Algorithm("List to sum", fA)
  override val b = Algorithm("Seq to sum", fB)

  private def fA(seed: Int, i: Int): Int = {
    l.sum
  }

  private def fB(seed: Int, i: Int): Int = {
    s.sum
  }

}

