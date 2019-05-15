package com.clrs.c02

import com.clrs.c01.SortingProblem

import scala.reflect.ClassTag
import scala.math.Ordering.Implicits.infixOrderingOps

/** Array in-place Insertion sort
  * Chapter 2, Section 2.1, Page 18
  */
object ArrayInsertionSort extends SortingProblem {

  /** In-place indexed (random-access) insertion sort.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    */
  def insertionSort[Key: Ordering](a: Array[Key]): Unit =
    for (j <- 1 until a.length) {
      val key = a(j)
      var i   = j - 1
      while (i >= 0 && key < a(i)) {
        a(i + 1) = a(i)
        i = i - 1
      }
      a(i + 1) = key
    }

  override def sort[Key: Ordering: ClassTag](input: Seq[Key]): Seq[Key] = {
    val array = input.toArray
    insertionSort(array)
    array
  }

}
