package com.clrs.c04

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.OptionValues
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import org.scalatest.matchers.should.Matchers

/** Abstract property-driven tests for maximum sub-array finders.
  *
  * @param alg Maximum sub array class.
  */
abstract class MaxSubSeqPropertyTest(alg: MaxSubSeq)
    extends AnyPropSpec
    with Matchers
    with ScalaCheckPropertyChecks
    with OptionValues {

  property("Returns None for empty arrays") {
    alg.maxSubSeq(IndexedSeq.empty[Int]) shouldBe None
  }

  property("Works for a simple array") {
    val a = Vector(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, -15, -4, 7)
    alg.maxSubSeq(a).value shouldBe SubSequence(7, 10, 43)
  }

  property("Returns the whole array as sub-sequence for singleton arrays") {
    forAll(Gen.containerOfN[Array, BigInt](1, arbitrary[BigInt])) { a =>
      val result = alg.maxSubSeq(a).value
      result.start shouldBe 0
      result.end   shouldBe 0
      result.sum   shouldBe a.head
    }
  }

  property("Max sub-array of positive integers spans the whole array") {
    forAll(Gen.nonEmptyContainerOf[Vector, Long](Gen.chooseNum(1L, 100L))) { vec =>
      val result = alg.maxSubSeq(vec).value
      result.start shouldBe 0
      result.end   shouldBe vec.indices.last
    }
  }

}

class BruteForceMaxSubSeqTest    extends MaxSubSeqPropertyTest(BruteForceMaxSubSeq)
class DivideConquerMaxSubSeqTest extends MaxSubSeqPropertyTest(DivideConquerMaxSubSeq)
class KadaneMaxSubSeqTest        extends MaxSubSeqPropertyTest(KadaneMaxSubSeq)
