package com.clrs.c02

import org.scalacheck.Arbitrary
import org.scalatest.{Matchers, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.collection.{IndexedSeq, LinearSeq}
import scala.language.higherKinds

/** Abstract property-driven tests for linear searches classes conforming to Search.
  *
  * @param alg Search class, an implementation of Search with linear search.
  * @tparam T Parametric type of the elements.
  * @tparam C Parametric type of the collection.
  * @param arb Implicit arbitrary for generating random sequences of elements.
  */
abstract class LinearSearchPropertyTest[T: Ordering: Arbitrary, C[_] <: Iterable[_]](alg: Search[C])(
  implicit arb: Arbitrary[C[T]]
) extends PropSpec
    with Matchers
    with ScalaCheckPropertyChecks {

  property("i ∈ [0, a.length)") {
    forAll { (a: C[T], x: T) =>
      val maybeIndex = alg.search(a, x)
      maybeIndex.forall(a.toIndexedSeq.indices.contains) shouldBe true
    }
  }

  property("a(i) = x") {
    forAll { (a: C[T], x: T) =>
      val maybeIndex = alg.search(a, x)
      maybeIndex.map(a.toVector).forall(_ == x) shouldBe true
    }
  }

  property("a(j) ≠ x         ∀ j < i") {
    forAll { (x: T, xs: C[T]) =>
      val i = alg.search(xs, x).getOrElse(xs.size)
      xs.take(i).forall(_ != x) shouldBe true
    }
  }

}

class IndexedSeqByteLinearSearchTest    extends LinearSearchPropertyTest[Byte, IndexedSeq](IndexedSeqLinearSearch)
class IndexedSeqBooleanLinearSearchTest extends LinearSearchPropertyTest[Boolean, IndexedSeq](IndexedSeqLinearSearch)
class LinearSeqByteLinearSearchTest     extends LinearSearchPropertyTest[Byte, LinearSeq](LinearSeqLinearSearch)
class LinearSeqBooleanLinearSearchTest  extends LinearSearchPropertyTest[Boolean, LinearSeq](LinearSeqLinearSearch)
