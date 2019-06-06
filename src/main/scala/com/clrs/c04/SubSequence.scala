package com.clrs.c04

import com.clrs.common.Index
import scala.math.Numeric.Implicits.infixNumericOps

/** Represents a sub-sequence (sub array in the book's terminology).
  *
  * @param start Start index of the sub-sequence (inclusive).
  * @param end End index of the sub-sequence (inclusive).
  */
case class SubSequence(start: Index, end: Index) {

  /** Returns the differential of the two ends of the given sequence.
    *
    * @param a Numeric sequence.
    * @tparam T Parametric type of elements.
    * @return a(end) - a(start).
    */
  def diff[T: Numeric](a: collection.IndexedSeq[T]): T = a(end) - a(start)

}
