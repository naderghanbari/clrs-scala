package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.collection.immutable
import scala.math.Ordering.Implicits.infixOrderingOps

/** Immutable Insertion sort.
  * A Cons List, known as the type `List` in Scala, is a persistent functional
  * data structure.
  */
class ImmutableInsertionSort[K: Ordering] extends GenericSort[K, immutable.Seq] {

  /** Functional side-effect free cons list insertion sort.
    *
    * @param xs Cons list of n numbers < a₁, a₂, ..., an >
    * @return A permutation < a′₁, a′₂, ..., a′n > of the input list such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def insertionSort(xs: immutable.Seq[K]): immutable.Seq[K] =
    xs.foldLeft(immutable.Seq.empty[K]) { (sortedPrefix, x) =>
      sortedPrefix.partition(x > _) match {
        case (less, greater) => (less :+ x) ++ greater
      }
    }

  override def sort(input: immutable.Seq[K]): immutable.Seq[K] =
    insertionSort(input)

}
