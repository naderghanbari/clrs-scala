package com.clrs.c02

import org.scalacheck.Arbitrary
import org.scalatest.{Matchers, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.collection.{IndexedSeq, LinearSeq}
import scala.language.higherKinds

/** Abstract property-driven tests for linear searches classes conforming to GenericSearch.
  *
  * @param alg Search class, an implementation of GenericSearch with linear search.
  * @tparam T Parametric type of the elements.
  * @tparam C Parametric type of the collection.
  * @param arbitrary$T$0 Implicit arbitrary for generating random elements.
  * @param arb Implicit arbitrary for generating random sequences of elements.
  */
abstract class LinearSearchTest[T: Arbitrary, C[_] <: Iterable[_]](alg: GenericSearch[C])(
  implicit arb: Arbitrary[C[T]],
  ord: Ordering[T]
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

class IndexedSeqByteLinearSearchTest    extends LinearSearchTest[Byte, IndexedSeq](IndexedSeqLinearSearch)
class IndexedSeqBooleanLinearSearchTest extends LinearSearchTest[Boolean, IndexedSeq](IndexedSeqLinearSearch)
class LinearSeqByteLinearSearchTest     extends LinearSearchTest[Byte, LinearSeq](LinearSeqLinearSearch)
class LinearSeqBooleanLinearSearchTest  extends LinearSearchTest[Boolean, LinearSeq](LinearSeqLinearSearch)
