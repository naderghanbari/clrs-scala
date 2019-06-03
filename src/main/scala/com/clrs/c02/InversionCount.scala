package com.clrs.c02

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Inversion count, a modification of Merge sort.
  * Chapter 2, Problem 2.4, Part d, Page 42
  */
object InversionCount {

  /** Merges sub-sequences of the given sequence and counts number of
    * inversions in the range [p, q].
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param q Split point.
    * @param r End index.
    * @return Number of inversions.
    */
  private def countAndMerge[T: Ordering](a: mutable.IndexedSeq[T], p: Int, q: Int, r: Int): Int = {
    val (left, right)  = (a.slice(p, q + 1), a.slice(q + 1, r + 1))
    var (inv, i, j, k) = (0, 0, 0, p)
    while (i != left.length && j != right.length) {
      if (right(j) < left(i)) inv += left.length - i
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
    inv
  }

  /** Inversion count for mutable indexed sequences.
    * Sorts the sequence as a side effect! Make a copy prior
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @return Number of inversions in the input sequence.
    */
  def inversionCount[T: Ordering](a: mutable.IndexedSeq[T]): Int = {
    def rec(p: Int, r: Int): Int =
      if (p < r) {
        val q = (p + r) / 2
        rec(p, q) + rec(q + 1, r) + countAndMerge(a, p, q, r)
      } else
        0

    rec(0, a.length - 1)
  }

}
