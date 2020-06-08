package com.clrs.c05

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalacheck.Gen.chooseNum
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class RandomTest extends AnyPropSpec with Matchers with ScalaCheckPropertyChecks {

  property("Random.slow(0, 1) returns 0 or 1") {
    Set.fill(100)(Random.slow(0, 1)) should contain theSameElementsAs Set(0, 1)
  }

  property("Random.slow(a, b) throws error if a > b") {
    forAll(arbitrary[Int], arbitrary[Int], minSuccessful(5)) { (a, b) =>
      whenever(a > b) {
        assertThrows[IllegalArgumentException] {
          Random.slow(a, b)
        }
      }
    }
  }

  property("Random.slow(a, b) returns a random number in the range [a, b]") {
    forAll(chooseNum(-100, 100), chooseNum(-100, 100), minSuccessful(1)) { (x, y) =>
      val (a, b) = (x min y, x max y)
      val result = Random.slow(a, b)
      result shouldBe >=(a)
      result shouldBe <=(b)
    }
  }

  property("Random(0, 1) returns 0 or 1") {
    Set.fill(100)(Random(0, 1)) should contain theSameElementsAs Set(0, 1)
  }

  property("Random(a, b) throws error if a > b") {
    forAll(arbitrary[Int], arbitrary[Int], minSuccessful(5)) { (a, b) =>
      whenever(a > b) {
        assertThrows[IllegalArgumentException] {
          Random(a, b)
        }
      }
    }
  }

  property("Random(a, b) returns a random number in the range [a, b]") {
    forAll(arbitrary[Int], arbitrary[Int], minSuccessful(10)) { (x, y) =>
      val (a, b) = (x min y, x max y)
      val result = Random(a, b)
      result shouldBe >=(a)
      result shouldBe <=(b)
    }
  }

  property("Random(0, 8) returns a random number in the range [0, 8]") {
    forAll(Gen.const(0), Gen.const(8), minSuccessful(100)) { (a, b) =>
      val result = Random(a, b)
      result shouldBe >=(a)
      result shouldBe <=(b)
      print(result)
    }
  }

}
