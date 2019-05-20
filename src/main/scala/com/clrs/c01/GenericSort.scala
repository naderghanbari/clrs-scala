package com.clrs.c01

import scala.language.higherKinds

/** Sorting problem.
  * Chapter 1, Section 1.1., page 5
  *
  * Implementations, depending on the mutability or immutability of the collection type,
  * may or may not mutate the passed sequence.
  *
  * @tparam K Generic type of elements.
  * @tparam Col Generic type of the collection.
  */
abstract class GenericSort[K: Ordering, Col[_] <: Iterable[_]] {

  /** Sorts the given input and returns the sorted permutation.
    *
    * @param input Sequence of n numbers < a₁, a₂, ..., an >
    * @return A permutation (reordering) < a′₁, a′₂, ..., a′n > of the input such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def sort(input: Col[K]): Col[K]

}
