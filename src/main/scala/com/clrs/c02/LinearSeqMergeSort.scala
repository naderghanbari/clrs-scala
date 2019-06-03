package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.annotation.tailrec
import scala.collection.LinearSeq
import scala.math.Ordering.Implicits.infixOrderingOps

/** LinearSeq merge sort.
  * Chapter 2, Section 2.3, Variant
  *
  * Works for both mutable and immutable LinearSeq collections.
  * Avoids reversing by reversing the order of merge in each iteration.
  */
object LinearSeqMergeSort extends GenericSort[LinearSeq] {

  /** Directional merge for LinearSeq collections with efficient
    * `head`, `tail` and `prepend` operations.
    *
    * @param left Left sequence.
    * @param right Right sequence.
    * @param ord Direction of the merge (order).
    * @tparam T Parametric type of elements.
    * @return Merged sequence, will be a sorted sequence conforming to the given direction.
    */
  def merge[T](left: LinearSeq[T], right: LinearSeq[T])(implicit ord: Ordering[T]): LinearSeq[T] = {
    @tailrec def rec(l: LinearSeq[T], r: LinearSeq[T], acc: LinearSeq[T]): LinearSeq[T] =
      (l.headOption, r.headOption) match {
        case (None, None)                            => acc
        case (Some(best), None)                      => rec(l.tail, Nil, best +: acc)
        case (None, Some(best))                      => rec(Nil, r.tail, best +: acc)
        case (Some(next), Some(best)) if best < next => rec(l, r.tail, best +: acc)
        case (Some(best), _)                         => rec(l.tail, r, best +: acc)
      }
    rec(left, right, LinearSeq.empty[T])
  }

  def mergeSort[T](list: LinearSeq[T])(implicit ord: Ordering[T]): LinearSeq[T] =
    list.length / 2 match {
      case 0 =>
        list
      case mid =>
        val rev           = ord.reverse
        val (left, right) = list.splitAt(mid)
        merge(mergeSort(left)(rev), mergeSort(right)(rev))(rev)
    }

  def sort[T: Ordering](input: LinearSeq[T]): LinearSeq[T] =
    mergeSort(input)

}
