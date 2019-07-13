package com.clrs.c08

import com.clrs.common.IndexKey

import scala.collection.mutable.ArrayBuffer

/**
  * Counting sort for cons lists.
  *
  * @author Nader Ghanbari
  */
object ConsListCountingSort {

  /**
    * Stable counting sort for cons lists.
    *
    * Not the most efficient algorithm, relies on `Array#toList` and `List#flatten`
    *
    * @param k     Maximum. All numbers should be less than or equal to k.
    * @param input Cons list of n numbers < a₁, a₂, ..., an >
    * @return Sorted cons list.
    */
  def countingSort[T <: IndexKey](k: Int)(input: List[T]): List[T] =
    input.foldLeft(Array.fill(k + 1)(ArrayBuffer.empty[T])) { (arr, x) => arr(x.key).append(x); arr }.toList.flatten

}
