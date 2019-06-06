package com.clrs.c04

import scala.math.Ordering.Implicits.infixOrderingOps

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
  def maxSubSeq[T: Numeric](a: collection.IndexedSeq[T]): Option[SubSequence] =
    a.indices
      .combinations(2)
      .map { case IndexedSeq(x, y) => SubSequence(x, y) }
      .map(sub => sub -> sub.diff(a))
      .maxByOption(_._2)
      .filter(_._2 > implicitly[Numeric[T]].zero)
      .map(_._1)
      .orElse(a.headOption.map(_ => SubSequence(0, 0)))

}
