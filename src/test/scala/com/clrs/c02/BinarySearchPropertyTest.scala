package com.clrs.c02

import org.scalacheck.Arbitrary
import org.scalatest.{Matchers, OptionValues, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.collection.IndexedSeq
import scala.language.higherKinds

/** Abstract property-driven tests for binary searches classes conforming to GenericSearch.
  *
  * @param alg Search class, an implementation of GenericSearch with binary search.
  * @tparam T Parametric type of the elements.
  * @param arbitrary$T$0 Implicit arbitrary for generating random elements.
  * @param arb Implicit arbitrary for generating random sequences of elements.
  */
abstract class BinarySearchPropertyTest[T: Arbitrary: Ordering](alg: GenericSearch[IndexedSeq])(
  implicit arb: Arbitrary[IndexedSeq[T]]
) extends PropSpec
    with Matchers
    with OptionValues
    with ScalaCheckPropertyChecks {

  property("i ∈ [0, a.length)") {
    forAll { (unsorted: IndexedSeq[T], x: T) =>
      val a          = unsorted.sorted
      val maybeIndex = alg.search(a, x)
      maybeIndex.forall(a.indices.contains) shouldBe true
    }
  }

  property("a(i) = x") {
    forAll { (unsorted: IndexedSeq[T], x: T) =>
      val a          = unsorted.sorted
      val maybeIndex = alg.search(a, x)
      maybeIndex.map(a).forall(_ == x) shouldBe true
    }
  }

  property("a(j) ≠ x         ∀ j < i") {
    forAll { (unsorted: IndexedSeq[T], x: T) =>
      val a = unsorted.sorted
      val i = alg.search(a, x).getOrElse(a.size)
      a.take(i).contains(x) shouldBe false
    }
  }

  property("Singleton sequence") {
    forAll { x: T =>
      val a     = IndexedSeq(x)
      val index = alg.search(a, x)
      index       shouldBe 'defined
      index.value shouldBe 0
    }
  }

}

class ByteBinarySearchTest extends BinarySearchPropertyTest[Byte](BinarySearch)
//class BooleanBinarySearchTest extends BinarySearchPropertyTest[Boolean](BinarySearch)
