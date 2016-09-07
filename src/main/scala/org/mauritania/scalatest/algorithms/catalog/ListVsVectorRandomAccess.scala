package org.mauritania.scalatest.algorithms.catalog

import org.mauritania.scalatest.algorithms.{Algorithm, Comparables}

object ListVsVectorRandomAccess extends Comparables {

  val kLOr = Range(1, 1000).toList
  val kVOr = Range(1, 1000).toVector

  override val a = Algorithm("List for random access", fA)
  override val b = Algorithm("Vector for random access", fB)

  private def fA(seed: Int): Int = {
    val k = kLOr.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

  private def fB(seed: Int): Int = {
    val k = kVOr.reverse
    k(0) + k(10) + k(20) + k(30) + k(40) + k(50) + k(60) + k(70) + k(80) + k(90) + k(190) + k(290) + k(391) + k(392) + k(393) + k(394)
  }

}


