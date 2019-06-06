package com.clrs.c02

import com.clrs.common.Index

import scala.collection.IndexedSeq
import scala.annotation.tailrec
import scala.math.Ordering.Implicits.infixOrderingOps

/** Binary search for sorted indexed sequences.
  * Works for both mutable and immutable indexed sequences.
  *
  * Guarantees to return the first occurrence of a value, if any.
  * Time complexity is still O(lgn).
  *
  * Scala 2.13-RC2 standard library has a binary search method on `IndexedSeq` which
  * returns the first index found during a normal binary search, that is without look-back.
  * Hence there is no guarantee that the returned index is the first occurrence.
  *
  * Chapter 2, Section 2.3, Exercise 2.3-5, Page 39
  */
object BinarySearch extends Search[IndexedSeq] {

  def binarySearch[T: Ordering](a: IndexedSeq[T], v: T): Option[Index] = {
    @tailrec def rec(l: Index, h: Index): Option[Int] =
      if (l <= h) {
        val m = (l + h) / 2
        a(m) match {
          case `v` if m == 0 || a(m - 1) < v => Some(m)
          case small if v > small            => rec(m + 1, h)
          case _                             => rec(l, m - 1)
        }
      } else None

    rec(0, a.length - 1)
  }

  def search[T: Ordering](a: IndexedSeq[T], v: T): Option[Index] = {
    binarySearch(a, v)
  }

}
