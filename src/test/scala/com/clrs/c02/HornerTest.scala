package com.clrs.c02

import com.clrs.c02.Horner.polynomialEval
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen.nonEmptyListOf
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers

class HornerTest extends AnyPropSpec with Matchers with ScalaCheckPropertyChecks {

  val polyGen = nonEmptyListOf(arbitrary[Double])

  property("Horner's rule works for simple polynomials") {
    val plusOneSquared = List(1.0, 2.0, 1.0)
    val plusOneCubed   = List(1.0, 3.0, 3.0, 1.0)
    polynomialEval(plusOneSquared)(3)  === 16.0
    polynomialEval(plusOneSquared)(10) === 121.0
    polynomialEval(plusOneCubed)(5)    === 216.0
  }

  property("f = c ⇒ f(x) = c ∀ x") {
    forAll(arbitrary[Double] -> "a0", arbitrary[Double] -> "c") { (a0, x) =>
      polynomialEval(List(a0))(x) === a0
    }
  }

  property("f(0) = a₀") {
    forAll(polyGen -> "f") { f =>
      polynomialEval(f)(0) === f.head
    }
  }

  property("f(1) = Σai") {
    forAll(polyGen -> "f") { f =>
      polynomialEval(f)(1.0) === f.sum
    }
  }

  property("(f + g)(x) = f(x) + g(x)") {
    forAll(polyGen -> "f", polyGen -> "g", arbitrary[Double] -> "x") { (f, g, x) =>
      val `f+g` = f.zipAll(g, 0.0, 0.0).map(Function.tupled(_ + _))
      polynomialEval(`f+g`)(x) === polynomialEval(f)(x) + polynomialEval(g)(x)
    }
  }

}
