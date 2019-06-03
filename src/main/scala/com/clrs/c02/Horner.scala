package com.clrs.c02

/** Horner's rule.
  * Chapter 2, Problem 2-3, Page 41
  */
object Horner {

  /** Horner's rule for evaluating polynomials.
    * Runs in O(n) where n is the degree of the polynomial.
    *
    * @param coefficients Polynomial coefficients: < a₀, a₁, a₂, ..., an >
    * @param x Point to evaluate polynomial at.
    * @return Value of the polynomial at point x.
    */
  def polynomialEval(coefficients: Iterable[Double])(x: Double): Double =
    coefficients.foldRight(0.0)((ai, y) => ai + x * y)

}
