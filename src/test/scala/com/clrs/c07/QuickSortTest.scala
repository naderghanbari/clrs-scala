package com.clrs.c07

import org.scalatest.{FlatSpec, Matchers}

class QuickSortTest extends FlatSpec with Matchers {

  "QuickSort.sort" should "return a sorted array" in {
    val input  = Array(100, 44, 1023, 5678, 5, 2, 4, 6, 1, 9999)
    val output = QuickSort.sort(input)
    output shouldBe sorted
  }

}
