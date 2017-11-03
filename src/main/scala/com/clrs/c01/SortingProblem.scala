package com.clrs.c01

import scala.reflect.ClassTag

/**
  * Sorting problem
  * Chapter 1, Section 1.1., page 5
  *
  * @author Nader Hadji Ghanbari
  */
trait SortingProblem {

  /**
    * A sorting problem. Generally the sort does not need to mutate the input sequence but
    * most sorting algorithms discussed in the book will mutate the input sequence.
    *
    * @param input Sequence of n numbers < a₁, a₂, ..., an >
    * @tparam Key Type of the keys.
    * @return A permutation (reordering) < a′₁, a′₂, ..., a′n > of the input such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def sort[Key: Ordering : ClassTag](input: Seq[Key]): Seq[Key]

}
