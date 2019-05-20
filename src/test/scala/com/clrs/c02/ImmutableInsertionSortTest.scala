package com.clrs.c02

import org.scalatest.{FlatSpec, Matchers}

class ImmutableInsertionSortTest extends FlatSpec with Matchers {

  "ConsListInsertionSort.sort" should "sort an array in place" in {
    val input  = List(5, 2, 4, 6, 1, 3)
    val output = new ImmutableInsertionSort[Int]().sort(input)
    output shouldBe sorted
  }

}