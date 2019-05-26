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
  */
abstract class BinarySearchPropertyTest[T: Ordering: Arbitrary](alg: GenericSearch[IndexedSeq])
    extends PropSpec
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

}

class ByteBinarySearchTest    extends BinarySearchPropertyTest[Byte](BinarySearch)
class BooleanBinarySearchTest extends BinarySearchPropertyTest[Boolean](BinarySearch)
