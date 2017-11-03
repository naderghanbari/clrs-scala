package com.clrs.c08

import com.clrs.c01.SortingProblemTest
import com.clrs.common.SatelliteObject
import com.clrs.common.SatelliteObject.orderingByKey

object AlternativeArrayCountingSortTest extends App {
  val k = 5

  val a = Array(
    SatelliteObject(2, "First 2"),
    SatelliteObject(5, "First 5"),
    SatelliteObject(3, "First 3"),
    SatelliteObject(0, "First 0"),
    SatelliteObject(2, "Second 2"),
    SatelliteObject(3, "Second 3"),
    SatelliteObject(0, "Second 0"),
    SatelliteObject(3, "Second 3"),
  )
  println(a.mkString("[", ", ", "]"))

  println("-------------------------------------------")
  println(s"ALTERNATIVE ARRAY COUNTING SORT ( K = $k )")
  println("-------------------------------------------")

  val sorted = AlternativeArrayCountingSort.countingSort(k)(a)
  println(sorted.mkString("SORTED [", ", ", "]"))

  assert(SortingProblemTest.isSorted(sorted))
}
