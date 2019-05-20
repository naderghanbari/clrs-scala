package com.clrs.c02

import com.clrs.c01.GenericSort

import scala.language.higherKinds
import scala.collection.immutable.Seq
import scala.math.Ordering.Implicits.infixOrderingOps

/** Immutable Insertion sort.
  * Cons List, known as the type `List` in Scala, is a persistent functional
  * data structure. It is the default implementation of `Seq`.
  */
object ImmutableInsertionSort extends GenericSort {

  type C[T] = Seq[T]

  /** Inserts x in the middle of an already sorted sequence an returns the result based on the
    * provided ordering.
    *
    * @param asc Already sorted sequence.
    * @param x Item to insert.
    * @param ord Item to insert.
    * @return New sequence with x inserted.
    */
  def insert[T](asc: C[T], x: T)(implicit ord: Ordering[T]): C[T] =
    asc.span(x > _) match { case (left, right) => (left :+ x) ++ right }

  /** Functional side-effect free cons list insertion sort.
    *
    * @param xs Cons list of n numbers < a₁, a₂, ..., an >
    * @return A permutation < a′₁, a′₂, ..., a′n > of the input list such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def insertionSort[T: Ordering](xs: C[T]): C[T] =
    xs.view.foldLeft(Seq.empty[T])(insert)

  def sort[T: Ordering](input: C[T]): C[T] =
    insertionSort(input)

}
