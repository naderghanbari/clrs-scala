package com.clrs.c04

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatest.{Matchers, OptionValues, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.higherKinds

/** Abstract property-driven tests for maximum sub-array finders.
  *
  * @param alg Maximum sub array class.
  */
abstract class MaxSubSeqPropertyTest(alg: MaxSubSeq)
    extends PropSpec
    with Matchers
    with ScalaCheckPropertyChecks
    with OptionValues {

  property("Returns None for empty arrays") {
    alg.maxSubSeq(IndexedSeq.empty[Int]) shouldBe None
  }

  property("Returns a zero sum for singleton arrays") {
    forAll(Gen.containerOfN[Array, BigInt](1, arbitrary[BigInt])) { a =>
      val result = alg.maxSubSeq(a).value
      result.diff(a) shouldBe 0
      result.start   shouldBe 0
      result.end     shouldBe 0
    }
  }

  property("Always returns a non-negative sum for non-empty integer arrays") {
    forAll(Gen.nonEmptyContainerOf[Array, BigInt](arbitrary[BigInt])) { a =>
      alg.maxSubSeq(a).value.diff(a) >= 0 shouldBe true
    }
  }

  property("Max sub-array of sorted distinct array spans the whole array") {
    forAll(Gen.nonEmptyContainerOf[Set, BigInt](arbitrary[BigInt])) { set =>
      val vec    = set.toVector.sorted
      val result = alg.maxSubSeq(vec).value
      result.start shouldBe 0
      result.end   shouldBe vec.indices.last
    }
  }

  property("Max sub-array of reverse sorted distinct array has a zero sum") {
    forAll(Gen.nonEmptyContainerOf[Set, BigInt](arbitrary[BigInt])) { set =>
      val vec    = set.toVector.sorted.reverse
      val result = alg.maxSubSeq(vec).value
      result.diff(vec) shouldBe 0
      result.start     shouldBe 0
      result.end       shouldBe 0
    }
  }

}
