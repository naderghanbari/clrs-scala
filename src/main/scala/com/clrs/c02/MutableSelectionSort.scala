package com.clrs.c02

import com.clrs.c01.Sort
import com.clrs.common.swap

import scala.collection.mutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Mutable selection sort.
  * Chapter 2, Exercise 2.2-2, Page 29
  */
object MutableSelectionSort extends Sort[mutable.IndexedSeq] {

  /** In-place indexed (random-access) selection sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @return Sorted sequence.
    */
  def selectionSort[T: Ordering](a: mutable.IndexedSeq[T]): Unit =
    for (i <- 0 until a.length - 1) {
      var argmin = i
      (i + 1 until a.length).withFilter(a(_) < a(argmin)).foreach(argmin = _)
      swap(a)(argmin, i)
    }

  def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    selectionSort(input)
    input
  }

}
