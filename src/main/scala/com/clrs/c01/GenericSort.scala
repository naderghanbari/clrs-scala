package com.clrs.c01

import scala.language.higherKinds

/** Sorting problem.
  * Chapter 1, Section 1.1., page 5
  *
  * Implementations, depending on the mutability or immutability of the collection type,
  * may or may not mutate the passed sequence.
  *
  * Abstract type C: Type of the collection.
  */
trait GenericSort {

  type C[T] <: Iterable[T]

  /** Sorts the given input and returns the sorted permutation.
    *
    * Implicit param ord: Order relation. Decouples the sort logic from the order relation.
    *
    * @param input Sequence of n numbers < a₁, a₂, ..., an >
    * @return A permutation (reordering) < a′₁, a′₂, ..., a′n > of the input such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def sort[T: Ordering](input: C[T]): C[T]

}
