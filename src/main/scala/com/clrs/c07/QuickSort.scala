package com.clrs.c07

import com.clrs.c01.SortingProblem
import com.clrs.common.swap

import scala.reflect.ClassTag
import scala.math.Ordering.Implicits.infixOrderingOps

/** QuickSort
  * Chapter 7, Section 7.1, Page 171
  */
object QuickSort extends SortingProblem {

  /** In-place partitioning.
    *
    * @param a Array of n numbers < a₁, a₂, ..., an >
    * @param p Start index.
    * @param r End index.
    */
  def partition[Key: Ordering](a: Array[Key], p: Int, r: Int): Int = {
    val x        = a(r)
    var i        = p - 1
    for (j <- p until r) {
      if (a(j) <= x) {
        i += 1
        swap(a)(i, j)
      }
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
  def quickSort[Key: Ordering](a: Array[Key], p: Int, r: Int): Unit =
    if (p < r) {
      val q = partition(a, p, r)
      quickSort(a, p, q - 1)
      quickSort(a, q + 1, r)
    }

  override def sort[Key: Ordering: ClassTag](input: Seq[Key]): Seq[Key] = {
    val array = input.toArray
    quickSort(array, 0, array.length - 1)
    array
  }

}
