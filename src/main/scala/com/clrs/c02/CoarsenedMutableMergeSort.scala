package com.clrs.c02

import com.clrs.c01.GenericSort
import com.clrs.common.Index

import scala.collection.mutable

/** Coarsened Mutable MergeSort.
  * Chapter 2, Problem 2-1, Pages 39 and 40
  *
  * Sub sequences of length <= k will be sorted in-place using insertion sort.
  *
  * @param k Coarsening factor.
  */
class CoarsenedMutableMergeSort(k: Int) extends GenericSort[mutable.IndexedSeq] with MutableMerge {

  require(k > 0, "k has to be positive")

  /** Random-access mutable merge sort.
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    */
  def mergeSort[T: Ordering](a: mutable.IndexedSeq[T], p: Index, r: Index): Unit =
    if (p < r)
      if (r - p + 1 >= k) {
        val q = (p + r) / 2
        mergeSort(a, p, q)
        mergeSort(a, q + 1, r)
        merge(a, p, q, r)
      } else MutableInsertionSort.insertionSort(a, p, r)

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    mergeSort(input, 0, input.length - 1)
    input
  }

}
