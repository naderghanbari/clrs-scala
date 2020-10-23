package com.clrs.c02

import com.clrs.c01.Sort
import com.clrs.common.Index

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** In-place mutable insertion sort.
  * Chapter 2, Section 2.1, Page 18
  */
object MutableInsertionSort extends Sort[mutable.IndexedSeq] {

  /** In-place indexed (random-access) insertion sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @return Sorted sequence.
    */
  def insertionSort[T: Ordering](a: mutable.IndexedSeq[T], p: Index, r: Index): Unit =
    for (j <- p to r) {
      val key = a(j)
      var i   = j - 1
      while (i >= 0 && key < a(i)) {
        a(i + 1) = a(i)
        i = i - 1
      }
      a(i + 1) = key
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    insertionSort(input, 0, input.length - 1)
    input
  }

}
