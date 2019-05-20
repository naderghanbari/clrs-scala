package com.clrs.c07

import com.clrs.c01.GenericSort
import com.clrs.common.swap

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Mutable in-place QuickSort.
  * Chapter 7, Section 7.1, Page 171
  */
object MutableQuickSort extends GenericSort {

  type C[T] = mutable.IndexedSeq[T]

  /** In-place partitioning.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    * @return Split point.
    */
  def partition[T](a: C[T], p: Int, r: Int)(implicit ord: Ordering[T]): Int = {
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
  def quickSort[T: Ordering](a: C[T], p: Int, r: Int): Unit =
    if (p < r) {
      val q = partition(a, p, r)
      quickSort(a, p, q - 1)
      quickSort(a, q + 1, r)
    }

  def sort[T: Ordering](input: C[T]): C[T] = {
    quickSort(input, 0, input.length - 1)
    input
  }

}
