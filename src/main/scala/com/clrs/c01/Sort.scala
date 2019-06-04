package com.clrs.c01

import scala.language.higherKinds

/** Sorting problem.
  *
  * Chapter 1, Section 1.1., page 5
  *
  * Implementations, depending on the mutability or immutability of the collection type,
  * may or may not mutate the passed sequence.
  *
  * The Order relation has to be passed to the sort method as an implicit `Ordering` object which
  * decouples the sort logic from the order relation.
  *
  * @tparam C[_] Type of the collection.
  */
abstract class Sort[C[_] <: Iterable[_]] {

  /** Sorts the given input and returns the sorted permutation.
    *
    * @param input Sequence of n numbers < a₁, a₂, ..., an >
    * @tparam T Type of elements with an order relation, i.e. an implicit Ordering[T].
    * @return A permutation (reordering) < a′₁, a′₂, ..., a′n > of the input such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def sort[T: Ordering](input: C[T]): C[T]

}
