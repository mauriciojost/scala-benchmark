package org.mauritania.scalatest

import org.mauritania.scalatest.algorithms.catalog.Identity
import org.specs2.mutable._

object TesterSpec extends Specification {

  "The tester" should {

    "return similar bencharmks for identical algorithms" in {
      Tester.testComparables(Identity, 1000, 10000)
      done
    }

  }
}
