package com.clrs.c04

import com.clrs.common.Index

import scala.collection.IndexedSeq
import scala.math.Numeric.Implicits.infixNumericOps
import scala.math.Ordering.Implicits.infixOrderingOps

/** Divide and conquer O(n*lgn) max sub-array algorithm.
  * Chapter 4, Section 4.1, Pages 71, 72
  */
object DivideConquerMaxSubSeq extends MaxSubSeq {

  def maxSubSeq[T: Numeric](a: IndexedSeq[T]): Option[SubSequence[T]] =
    if (a.isEmpty) Option.empty[SubSequence[T]]
    else Some(findMax(a, 0, a.length - 1))

  private def findMax[T: Numeric](a: IndexedSeq[T], low: Index, high: Index): SubSequence[T] =
    if (low == high)
      SubSequence(low, high, a(low))
    else {
      val mid           = (low + high) / 2
      val (left, right) = (findMax(a, low, mid), findMax(a, mid + 1, high))
      val crossing      = findMaxCrossing(a, low, mid, high)
      if (left.sum >= (crossing.sum max right.sum)) left
      else if (crossing.sum >= (left.sum max right.sum)) crossing
      else right
    }

  private def findMaxCrossing[T](a: IndexedSeq[T], l: Index, m: Index, h: Index)(
    implicit num: Numeric[T]
  ): SubSequence[T] = {
    val rollingMax   = (range: Range) => range.view.map(a).scan(num.zero)(_ + _).drop(1).zipWithIndex.maxBy(_._1)
    val (lSum, lMax) = rollingMax(m to l by -1)
    val (rSum, rMax) = rollingMax(m + 1 to h)
    SubSequence(m - lMax, m + 1 + rMax, lSum + rSum)
  }

}
