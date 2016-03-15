package org.mauritania.scalatest.algorithms

import org.scalameter.api._

object PerfSpec extends Bench.LocalTime {
  val sizes = Gen.range("size")(20, 2000, 20)

  val ranges = for {
    size <- sizes
  } yield 0 until size

  performance of "Vector" in {
    measure method "++" in {
      using(ranges) in { r =>
        r.toVector ++ r.toVector
      }
    }
  }

  performance of "List" in {
    measure method "++" in {
      using(ranges) in { r =>
        r.toList ++ r.toList
      }
    }
  }
}
