package com.clrs.c04

import scala.language.higherKinds

/** Maximum sub-array problem.
  * Chapter 4, Section 4.1, Page 68
  *
  * Implementations do not take care of arithmetic overflows.
  */
trait MaxSubSeq {

  /** Finds the maximum sub-sequence,
    * that is the sub-sequence with maximum sum.
    *
    * @param a Input sequence.
    * @tparam T Parametric type of elements (numeric).
    * @return Maximum sub-sequence if any.
    */
  def maxSubSeq[T: Numeric](a: collection.IndexedSeq[T]): Option[SubSequence[T]]

}
