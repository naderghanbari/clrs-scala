package com.clrs.c02

import scala.language.higherKinds

import com.clrs.common.Index

/** Searching Problem
  *
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  *
  * @tparam C[_] Type of the collection.
  */
abstract class Search[C[_] <: Iterable[_]] {

  /** A searching problem.
    *
    * @param a A sequence of n numbers < a₁, a₂, ..., an >.
    * @param v Value to search for.
    * @tparam T Type of elements with a defined ordering.
    * @return An index i such that v = A[i] or `None` if v does not appear in A.
    */
  def search[T: Ordering](a: C[T], v: T): Option[Index]

}
