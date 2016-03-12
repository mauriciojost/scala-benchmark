package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.Comparables

object MapOnCollections extends Comparables {

  val l = Range(1, 1000).toList
  val s = Range(1, 1000).toSeq

  override def idA() = "List to sum"

  override def fA(seed: Int): Int = {
    l.sum
  }

  override def idB() = "Seq to sum"

  override def fB(seed: Int): Int = {
    s.sum
  }

}

