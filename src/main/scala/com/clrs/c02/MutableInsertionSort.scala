package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** In-place mutable insertion sort.
  * Chapter 2, Section 2.1, Page 18
  */
object MutableInsertionSort extends GenericSort[mutable.IndexedSeq] {

  /** In-place indexed (random-access) insertion sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    */
  def insertionSort[T: Ordering](a: mutable.IndexedSeq[T]): Unit =
    for (j <- 1 until a.length) {
      val key = a(j)
      var i   = j - 1
      while (i >= 0 && key < a(i)) {
        a(i + 1) = a(i)
        i = i - 1
      }
      a(i + 1) = key
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    insertionSort(input)
    input
  }

}
