package com.clrs.c08

import com.clrs.c01.SortingProblemTest
import com.clrs.common.SatelliteObject
import com.clrs.common.SatelliteObject.orderingByKey

object ConsListCountingSortTest extends App {
  val k = 5

  val a = List(
    SatelliteObject(2, "First 2"),
    SatelliteObject(5, "First 5"),
    SatelliteObject(3, "First 3"),
    SatelliteObject(0, "First 0"),
    SatelliteObject(2, "Second 2"),
    SatelliteObject(3, "Second 3"),
    SatelliteObject(0, "Second 0"),
    SatelliteObject(3, "Second 3"),
  )
  println(a.mkString("INPUT ", " :: ", " :: Nil"))

  println("-----------------------------------")
  println(s"CONS LIST COUNTING SORT ( K = $k )")
  println("-----------------------------------")

  val sorted = ConsListCountingSort.countingSort(k)(a)
  println(sorted.mkString("SORTED ", " :: ", " :: Nil"))

  assert(SortingProblemTest.isSorted(sorted))
}
