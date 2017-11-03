package com.clrs.c02

import com.clrs.c01.SortingProblemTest

object ConsListInsertionSortTest extends App {
  val a = List(5, 2, 4, 6, 1, 3)
  println(a.mkString("INPUT ", " :: ", " :: Nil"))


  println("------------------------")
  println("CONS LIST INSERTION SORT")
  println("------------------------")

  val sorted = ConsListInsertionSort.sort(a)
  println(sorted.mkString("SORTED ", " :: ", " :: Nil"))

  assert(SortingProblemTest.isSorted(sorted))
}
