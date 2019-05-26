package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.collection.mutable

/** In-Place variant of Mutable MergeSort.
  * Chapter 2, Section 2.3, Variant
  *
  * Runs in O(n lgn lgn) with no auxiliary space needed.
  */
object InPlaceMutableMergeSort extends GenericSort[mutable.IndexedSeq] with InPlaceMutableMerge {

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
      merge(a, p, q, r)
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    mergeSort(input, 0, input.length - 1)
    input
  }

}
