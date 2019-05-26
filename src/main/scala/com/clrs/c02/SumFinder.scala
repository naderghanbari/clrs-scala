package com.clrs.c02

import com.clrs.common.Index

import scala.math.Numeric.Implicits.infixNumericOps
import scala.math.Ordering.Implicits.infixOrderingOps
import scala.annotation.tailrec
import scala.collection.mutable
import scala.reflect.ClassTag

/** Finds two elements by their sum form a distinct set of elements in O(n lgn).
  * Chapter 2, Section 2.3, Exercise 2.3-7, Page 39
  */
object SumFinder {

  /** Find two elements by their sum.
    *
    * If there are more than one pair of elements with the given sum, returns the
    * pair with the biggest difference (most apart).
    *
    * @param set Distinct set of elements.
    * @param sum Desired sum.
    * @tparam T Parametric type of elements, should be numeric.
    * @return The first found two values if any, None otherwise.
    */
  def findBySum[T: Numeric: ClassTag](set: Set[T], sum: T): Option[(T, T)] = {
    val arr = MutableMergeSort.sort(set.to(mutable.IndexedSeq))

    @tailrec def find(i: Index, j: Index): Option[(T, T)] =
      if (i >= j) None
      else
        (arr(i), arr(j)) match {
          case (l, r) if l + r == sum => Some(l, r)
          case (l, h) if l + h < sum  => find(i + 1, j)
          case _                      => find(i, j - 1)
        }

    find(0, arr.length - 1)
  }

}
