package com.clrs.c02

import com.clrs.c02.InversionCount.inversionCount
import org.scalatest.{Matchers, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.higherKinds

/** Inversion count tests.
  * Chapter 2, Problem 2.4, Parts a and b, Pages 41, 42
  */
class InversionCountTest extends PropSpec with Matchers with ScalaCheckPropertyChecks {

  property("[2, 3, 8, 6, 1] has 5 inversions") {
    inversionCount(Array(2, 3, 8, 6, 1)) shouldBe 5
  }

  property("inversions([]) = 0") {
    inversionCount(Array.empty[Int]) shouldBe 0
  }

  property("inversions([x]) = 0") {
    forAll { x: Int =>
      inversionCount(Array(x)) shouldBe 0
    }
  }

  property("inversions(xs) ≥ 0") {
    forAll { xs: Array[Int] =>
      inversionCount(xs) should be >= 0
    }
  }

  property("inversions(xs) ≤ n choose 2") {
    forAll { xs: Array[Int] =>
      val n = xs.length
      inversionCount(xs) should be <= n * (n - 1) / 2
    }
  }

  property("inversions(sorted array) = 0") {
    forAll { xs: Array[Int] =>
      inversionCount(xs.sorted) shouldBe 0
    }
  }

  property("inversions(distinct reversed array) = n choose 2") {
    forAll { xs: Set[Int] =>
      val n = xs.size
      inversionCount(xs.toArray.sorted.reverse) shouldBe n * (n - 1) / 2
    }
  }

  property("monotonicity wrt shrinkage") {
    forAll { xs: Array[Int] =>
      inversionCount(xs) should be >= inversionCount(xs.dropRight(1))
    }
  }

}
