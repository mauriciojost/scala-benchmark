package org.mauritania.scalatest.algorithms

case class Algorithm (
  val id: String,
  val f: (Int, Int) => Int //(parameter: Int, initiationSeed: Int): Int
)
