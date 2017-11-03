package com.clrs.c02

import com.clrs.c01.SortingProblem

import scala.math.Ordering.Implicits.infixOrderingOps
import scala.reflect.ClassTag

/**
  * Functional Cons List Insertion sort.
  *
  * @author Nader Hadji Ghanbari
  */
object ConsListInsertionSort extends SortingProblem {

  /**
    * Functional side-effect free cons list insertion sort.
    *
    * @param xs Cons list of n numbers < a₁, a₂, ..., an >
    * @return Cons list < a′₁, a′₂, ..., a′n >, a permutation if input cons list such that a′₁ ≤ a′₂ ≤ ... ≤ a′n
    */
  def insertionSort[Key: Ordering](xs: List[Key]): List[Key] =
    xs.foldLeft(List.empty[Key]) { (sortedPrefix, x) =>
      sortedPrefix.partition(x > _) match {
        case (less, greater) => (less :+ x) ++ greater
      }
    }

  override def sort[Key: Ordering : ClassTag](input: Seq[Key]) = insertionSort(input.toList)

}
