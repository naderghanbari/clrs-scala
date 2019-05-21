package com.clrs.c02

import org.scalacheck.Arbitrary
import org.scalatest.{Matchers, PropSpec}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.higherKinds

/** Abstract property-driven tests for searching classes conforming to GenericSearch.
  *
  * @param alg Search class, an implementation of GenericSearch.
  * @tparam T Parametric type of the elements.
  * @tparam C Parametric type of the collection.
  * @param arbitrary$T$0 Implicit arbitrary for generating random elements.
  * @param arb Implicit arbitrary for generating random sequences of elements.
  */
abstract class GenericSearchTest[T: Arbitrary, C[_] <: Iterable[_]](alg: GenericSearch[C])(
  implicit arb: Arbitrary[C[T]]
) extends PropSpec
    with Matchers
    with ScalaCheckPropertyChecks {

  property("In range") {
    forAll { (x: T, xs: C[T]) =>
      alg.search(xs, x).forall(idx => idx >= 0 && idx < xs.size) shouldBe true
    }
  }

}
