package com.clrs.c02

import com.clrs.c01.SortingProblemTest

object ArrayInsertionSortTest extends App {
  val a = Array(5, 2, 4, 6, 1, 3)
  println(a.mkString("INPUT [", ", ", "]"))

  println("--------------------")
  println("ARRAY INSERTION SORT")
  println("--------------------")

  val sorted = ArrayInsertionSort.sort(a)
  println(sorted.mkString("SORTED [", ", ", "]"))

  assert(SortingProblemTest.isSorted(sorted))
}
