package com.clrs.c08

/**
  * Counting sort
  * Chapter 8, Section 8.2, Page 195
  *
  * @author Nader Hadji Ghanbari
  */
object ArrayCountingSort {

  /**
    * Stable counting sort for arrays of integers.
    *
    * Is not in-place, puts sorted numbers in an array provided as an input (side effect).
    *
    * @param k Maximum. All numbers should be less than or equal to k.
    * @param a Input: array of n numbers < a₁, a₂, ..., an >
    * @param b Output array. Make sure it's of the same dimension as the input array.
    */
  def countingSort(k: Int)(a: Array[Int], b: Array[Int]): Unit = {
    val c = Array.fill(k + 1)(0)
    a.foreach(c(_) += 1)
    for (i <- 1 to k) c(i) = c(i) + c(i - 1)
    for (j <- a.length - 1 to 0 by -1) {
      b(c(a(j)) - 1) = a(j)
      c(a(j)) -= 1
    }
  }

}
