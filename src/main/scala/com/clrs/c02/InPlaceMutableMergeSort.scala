package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** In-Place variant of Mutable MergeSort.
  * Chapter 2, Section 2.3, Variant
  *
  * Runs in O(n lgn lgn) with no auxiliary space needed.
  */
object InPlaceMutableMergeSort extends GenericSort[mutable.IndexedSeq] {

  /** In-place Merge function. Reduces auxiliary space
    * complexity at the price of time complexity.
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param start Start index.
    * @param mid split point.
    * @param end End index.
    */
  def inPlaceMerge[T](a: mutable.IndexedSeq[T], start: Int, mid: Int, end: Int)(implicit ord: Ordering[T]): Unit = {
    var (first, between, second) = (start, mid, mid + 1)
    if (a(between) > a(second))
      while (first <= between && second <= end) {
        if (a(first) > a(second)) {
          val smaller = a(second)
          for (i <- second until first by -1) a(i) = a(i - 1)
          a(first) = smaller
          between += 1
          second += 1
        }
        first += 1
      }
  }

  /** Random-access mutable merge sort.
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    */
  def mergeSort[T: Ordering](a: mutable.IndexedSeq[T], p: Int, r: Int): Unit =
    if (p < r) {
      val q = (p + r) / 2
      mergeSort(a, p, q)
      mergeSort(a, q + 1, r)
      inPlaceMerge(a, p, q, r)
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    mergeSort(input, 0, input.length - 1)
    input
  }

}
