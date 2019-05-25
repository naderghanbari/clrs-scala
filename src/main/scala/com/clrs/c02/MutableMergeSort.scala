package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Mutable MergeSort.
  * Chapter 2, Section 2.3, Pages 31 to 34
  */
object MutableMergeSort extends GenericSort[mutable.IndexedSeq] {

  /** Merge function, as in exercise 2.3-2, page 37.
    *
    * As using sentinels for parametric (polymorphic) types is not an option, we will
    * use the modified version as in exercise 2.3-2.
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param q split point.
    * @param r End index.
    */
  def merge[T](a: mutable.IndexedSeq[T], p: Int, q: Int, r: Int)(implicit ord: Ordering[T]): Unit = {
    val (left, right) = (a.slice(p, q + 1), a.slice(q + 1, r + 1))
    var (i, j, k)     = (0, 0, p)
    while (i != left.length && j != right.length) {
      if (left(i) < right(j)) {
        a(k) = left(i)
        i = i + 1
      } else {
        a(k) = right(j)
        j = j + 1
      }
      k = k + 1
    }
    if (i == left.length)
      for (m <- j until right.length) {
        a(k) = right(m)
        k = k + 1
      }
    if (j == right.length)
      for (m <- i until left.length) {
        a(k) = left(m)
        k = k + 1
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
      merge(a, p, q, r)
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    mergeSort(input, 0, input.length - 1)
    input
  }

}
