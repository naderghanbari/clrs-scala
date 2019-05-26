package com.clrs.c02

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** In-place Mutable merge function.
  * Chapter 2, Section 2.3, Variant
  */
trait InPlaceMutableMerge {

  /** In-place Merge function. Reduces auxiliary space
    * complexity at the price of time complexity.
    *
    * @param a Sequence of n numbers < a₁, a₂, ..., an >
    * @param start Start index.
    * @param mid split point.
    * @param end End index.
    */
  def merge[T: Ordering](a: mutable.IndexedSeq[T], start: Int, mid: Int, end: Int): Unit = {
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

}
