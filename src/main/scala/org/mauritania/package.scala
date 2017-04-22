package org.mauritania

import org.openjdk.jmh.annotations.{Scope, State}

package object mauritania {

  @State(Scope.Thread)
  val Seed = 1000

  @State(Scope.Thread)
  val ARange = Range(1, Seed)

  @State(Scope.Thread)
  val BaseList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  @State(Scope.Thread)
  val BaseArray = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  @State(Scope.Thread)
  val BaseVector = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  @State(Scope.Thread)
  val BaseSeq = Seq(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  @State(Scope.Thread)
  val QuarterLargeList = Range(1, Seed / 4).toList
  @State(Scope.Thread)
  val QuarterLargeArray = Range(1, Seed / 4).toArray
  @State(Scope.Thread)
  val QuarterLargeVector = Range(1, Seed / 4).toVector

  @State(Scope.Thread)
  val HalfLargeList = Range(1, Seed / 2).toList
  @State(Scope.Thread)
  val HalfLargeArray = Range(1, Seed / 2).toArray
  @State(Scope.Thread)
  val HalfLargeVector = Range(1, Seed / 2).toVector

  @State(Scope.Thread)
  val LargeList = Range(1, Seed).toList
  @State(Scope.Thread)
  val LargeArray = Range(1, Seed).toArray
  @State(Scope.Thread)
  val LargeVector = Range(1, Seed).toVector

  @State(Scope.Thread)
  val LargeCharArray = Range(1, Seed).map(_.toChar).toArray

}
