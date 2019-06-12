package com.clrs.c04

import scala.math.Ordering.Implicits.infixOrderingOps
import scala.math.Numeric.Implicits.infixNumericOps

/** Brute-force O(n²) solution to the maximum sub-array problem.
  * Chapter 4, Section 4.1, Page 69
  */
object BruteForceMaxSubSeq extends MaxSubSeq {

  /** Finds the maximum sub-sequence by checking all 2-combinations of the indices.
    *
    * @param a Input sequence.
    * @tparam T Parametric type of elements (numeric).
    * @return Maximum sub-sequence.
    */
  def maxSubSeq[T: Numeric](a: collection.IndexedSeq[T]): Option[SubSequence[T]] = {
    if (a.isEmpty)
      Option.empty[SubSequence[T]]
    else {
      var best = SubSequence(start = 0, end = 0, sum = a(0))
      for (i <- 0 until a.length) {
        var sum = implicitly[Numeric[T]].zero
        for (j <- i until a.length) {
          sum = sum + a(j)
          if (sum > best.sum) best = SubSequence(i, j, sum)
        }
      }
      Some(best)
    }
  }

}
