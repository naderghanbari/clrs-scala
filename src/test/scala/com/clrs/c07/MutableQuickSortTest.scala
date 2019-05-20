package com.clrs.c07

import org.scalatest.{FlatSpec, Matchers}

class MutableQuickSortTest extends FlatSpec with Matchers {

  "MutableQuickSort.sort" should "return a sorted array" in {
    val input  = Array(100, 44, 1023, 5678, 5, 2, 4, 6, 1, 9999)
    val output = MutableQuickSort.sort(input)
    output shouldBe sorted
  }

}
