package org.mauritania

package object mauritania {
  val Seed = 1000

  val BaseList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  val BaseArray = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  val BaseVector = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  val BaseSeq = Seq(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  val QuarterLargeList = Range(1, Seed / 4).toList
  val QuarterLargeArray = Range(1, Seed / 4).toArray
  val QuarterLargeVector = Range(1, Seed / 4).toVector

  val HalfLargeList = Range(1, Seed / 2).toList
  val HalfLargeArray = Range(1, Seed / 2).toArray
  val HalfLargeVector = Range(1, Seed / 2).toVector

  val LargeList = Range(1, Seed).toList
  val LargeArray = Range(1, Seed).toArray
  val LargeVector = Range(1, Seed).toVector

}
