package com.clrs.c02

import com.clrs.c01.Sort
import com.clrs.common

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** In-place mutable bubble sort.
  * Chapter 2, Problem 2-2, Page 40
  */
object MutableBubbleSort extends Sort[mutable.IndexedSeq] {

  /** In-place indexed (random-access) bubble sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @return Sorted sequence.
    */
  def bubbleSort[T: Ordering](a: mutable.IndexedSeq[T]): Unit =
    for (i <- 0 until a.length - 1)
      for (j <- a.length - 1 to i + 1 by -1 if a(j) < a(j - 1))
        common.swap(a)(j, j - 1)

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    bubbleSort(input)
    input
  }

}
