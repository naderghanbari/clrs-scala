package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.annotation.tailrec
import scala.math.Ordering.Implicits.infixOrderingOps

/** Immutable merge sort for lists.
  * Chapter 2, Section 2.3, Variant
  *
  * Avoids reversing lists by reversing the order of merge in each iteration.
  */
object ListMergeSort extends GenericSort[List] {

  /** Directional merge.
    *
    * @param left Left list.
    * @param right Right list.
    * @param ord Direction of the merge (order).
    * @tparam T Parametric type of elements.
    * @return Merged list, will be a sorted list conforming to the given direction.
    */
  def merge[T](left: List[T], right: List[T])(implicit ord: Ordering[T]): List[T] = {
    @tailrec def rec(l: List[T], r: List[T], acc: List[T]): List[T] =
      (l, r) match {
        case (Nil, Nil)                               => acc
        case (best :: rest, Nil)                      => rec(rest, Nil, best :: acc)
        case (Nil, best :: rest)                      => rec(Nil, rest, best :: acc)
        case (next :: _, best :: tail) if best < next => rec(l, tail, best :: acc)
        case (best :: tail, _)                        => rec(tail, r, best :: acc)
      }
    rec(left, right, List.empty[T])
  }

  def mergeSort[T](list: List[T])(implicit ord: Ordering[T]): List[T] =
    list match {
      case Nil | _ :: Nil =>
        list
      case _ =>
        val rev           = ord.reverse
        val (left, right) = list.splitAt(list.length / 2)
        merge(mergeSort(left)(rev), mergeSort(right)(rev))(rev)
    }

  def sort[T: Ordering](input: List[T]): List[T] =
    mergeSort(input)

}
