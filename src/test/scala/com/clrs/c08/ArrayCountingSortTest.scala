package com.clrs.c08

import com.clrs.c01.SortingProblemTest

object ArrayCountingSortTest extends App {
  val k = 5

  val a = Array(2, 5, 3, 0, 2, 3, 0, 3)
  println(a.mkString("[", ", ", "]"))

  println("-------------------------------")
  println(s"ARRAY COUNTING SORT ( K = $k )")
  println("-------------------------------")

  val b = Array.ofDim[Int](a.length)
  ArrayCountingSort.countingSort(k)(a, b)
  println(b.mkString("SORTED [", ", ", "]"))

  assert(SortingProblemTest.isSorted(b))
}
