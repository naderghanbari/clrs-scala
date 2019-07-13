package com.clrs.c04

import scala.collection.IndexedSeq
import scala.math.Numeric.Implicits.infixNumericOps
import scala.math.Ordering.Implicits.infixOrderingOps

/** Kadane's algorithm O(n) for the max sub-array algorithm.
  * Chapter 4, Exercise 4.1-5, Page 75
  */
object KadaneMaxSubSeq extends MaxSubSeq {

  def maxSubSeq[T: Numeric](a: IndexedSeq[T]): Option[SubSequence[T]] = {
    val zero = implicitly[Numeric[T]].zero
    a.view.zipWithIndex
      .scanLeft(SubSequence(-1, -1, zero)) {
        case (p, (x, i)) if p.sum > zero => SubSequence(p.start, i, p.sum + x)
        case (_, (x, i))                 => SubSequence(i, i, x)
      }
      .drop(1)
      .maxByOption(_.sum)
  }

}
