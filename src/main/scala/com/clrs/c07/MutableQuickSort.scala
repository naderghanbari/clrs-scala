package com.clrs.c07

import com.clrs.c01.Sort
import com.clrs.common.swap

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Mutable in-place QuickSort.
  * Chapter 7, Section 7.1, Page 171
  */
object MutableQuickSort extends Sort[mutable.IndexedSeq] {

  /** In-place partitioning.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    * @return Split point.
    */
  def partition[T](a: mutable.IndexedSeq[T], p: Int, r: Int)(implicit ord: Ordering[T]): Int = {
    val x = a(r)
    var i = p - 1
    for (j <- p until r if a(j) <= x) {
      i = i + 1
      swap(a)(i, j)
    }
    swap(a)(i + 1, r)
    i + 1
  }

  /** In-place indexed (random-access) quick sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    */
  def quickSort[T: Ordering](a: mutable.IndexedSeq[T], p: Int, r: Int): Unit =
    if (p < r) {
      val q = partition(a, p, r)
      quickSort(a, p, q - 1)
      quickSort(a, q + 1, r)
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    quickSort(input, 0, input.length - 1)
    input
  }

}
