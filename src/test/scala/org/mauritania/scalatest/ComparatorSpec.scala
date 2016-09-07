package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog.{IdentityX4, IdentityX2, Identity}
import org.mauritania.scalatest.result.Report
import org.scalatest.{FunSuite, Matchers}

class ComparatorSpec extends FunSuite with Matchers {

  val Seed = 100000
  val Iterations = 100
  val Tolerance = 0.05F

  test("report similar times for identity algorithms") {

    val report = Comparator.testComparables(Identity, Seed, Iterations)

    val (smaller, greater) = extractDurationsOrdered(report)
    val ratio = (smaller / greater)
    val expectedRatio = 1.0

    ratio should be > expectedRatio - Tolerance // very similar one to the other

  }


  test("report corresponding times for identityX2 algorithms") {

    val report = Comparator.testComparables(IdentityX2, Seed, Iterations)

    val (smaller, greater) = extractDurationsOrdered(report)
    val ratio = (smaller / greater)
    val expectedRatio = 0.5

    ratio should be > expectedRatio - Tolerance
    ratio should be < expectedRatio + Tolerance

  }

  test("report corresponding times for identityX4 algorithms") {

    val report = Comparator.testComparables(IdentityX4, Seed, Iterations)

    val (smaller, greater) = extractDurationsOrdered(report)
    val ratio = (smaller / greater)
    val expectedRatio = 0.25

    ratio should be > expectedRatio - Tolerance
    ratio should be < expectedRatio + Tolerance

  }

  private def extractDurations(report: Report): (Double, Double) = {
    val durationA = report.vsSamples.map(_.sampleA.duration).sum.toDouble
    val durationB = report.vsSamples.map(_.sampleB.duration).sum.toDouble
    (durationA, durationB)
  }

  private def extractDurationsOrdered(report: Report): (Double, Double) = {
    val (durationA, durationB) = extractDurations(report)
    val List(smaller, greater) = List(durationA, durationB).sorted
    (smaller, greater)
  }

}
