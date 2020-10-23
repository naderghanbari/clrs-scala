package com.clrs.c08

import com.clrs.common._

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

/** Stable counting sort using an auxiliary array of arrays, hence supporting satellite data.
  * As mentioned in lecture 7 of 6.006 Introduction to Algorithms, Fall 2011.
  *
  * @author Nader Ghanbari
  */
object AlternativeArrayCountingSort {

  /** Counting sort using an auxiliary Array[ArrayBuffer.
    *
    * @param k Maximum. All numbers should be less than or equal to k.
    * @param a Input: array of n numbers < a₁, a₂, ..., an >
    * @return Sorted array.
    */
  def countingSort[T <: IndexKey: ClassTag](k: Int)(a: Array[T]): Array[T] = {
    val l      = Array.fill(k + 1)(ArrayBuffer.empty[T])
    val output = ArrayBuffer.empty[T]
    a.foreach(aj => l(aj.key) append aj)
    l.foreach(output appendAll _)
    output.toArray
  }

}
