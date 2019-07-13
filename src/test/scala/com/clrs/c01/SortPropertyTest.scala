package com.clrs.c01

import org.scalacheck.Arbitrary
import org.scalatest.enablers.Sortable
import org.scalatest.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.higherKinds

/** Abstract property-driven tests for sorting classes conforming to Sort.
  *
  * @param alg Sort class, an implementation of Sort.
  * @tparam T Parametric type of the elements.
  * @tparam C Parametric type of the collection.
  * @param ordering$T$0 Implicit order for elements.
  * @param arb Implicit arbitrary for generating random sequences of elements.
  * @param sortable Implicit enabler for ScalaTest's `sorted` matcher.
  */
abstract class SortPropertyTest[T: Ordering, C[_] <: Iterable[_]](alg: Sort[C])(
  implicit arb: Arbitrary[C[T]],
  sortable: Sortable[C[T]]
) extends AnyPropSpec
    with Matchers
    with ScalaCheckPropertyChecks {

  property("Size invariance") {
    forAll { xs: C[T] =>
      alg.sort(xs).size shouldEqual xs.size
    }
  }

  property("Contents invariance") {
    forAll { xs: C[T] =>
      alg.sort(xs).toVector should contain theSameElementsAs xs.toVector
    }
  }

  property("Ascending result") {
    forAll { xs: C[T] =>
      alg.sort(xs) shouldBe sorted
    }
  }

  property("Descending order => descending result") {
    forAll { xs: C[T] =>
      val asc  = alg.sort(xs).toVector
      val desc = alg.sort(xs)(Ordering[T].reverse).toVector
      desc.reverse should contain theSameElementsInOrderAs asc
    }
  }

  property("Idempotent") {
    forAll { xs: C[T] =>
      alg.sort(alg.sort(xs)) shouldEqual alg.sort(xs)
    }
  }

}
