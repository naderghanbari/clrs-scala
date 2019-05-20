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
    xs.view.foldLeft(immutable.Seq.empty[K])(insert)

  override def sort(input: immutable.Seq[K]): immutable.Seq[K] =
    insertionSort(input)

  /** Inserts x in the middle of an already sorted sequence an returns the result.
    *
    * @param asc Already sorted sequence.
    * @param x Item to insert.
    * @return New sequence with x inserted.
    */
  private def insert(asc: Seq[K], x: K) =
    asc.span(_ < x) match { case (left, right) => (left :+ x) ++ right }

}
