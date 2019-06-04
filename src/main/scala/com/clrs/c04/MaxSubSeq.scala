package com.clrs.c04

import scala.collection.IndexedSeq

/** Maximum sub-array problem.
  * Chapter 4, Section 4.1, Page 68
  */
trait MaxSubSeq {

  /** Finds the maximum sub-sequence
    *
    * @param a Input sequence.
    * @tparam T Parametric type of elements (numeric).
    * @return Maximum sub-sequence if any.
    */
  def maxSubSeq[T: Numeric](a: IndexedSeq[T]): SubSequence[T]

}
