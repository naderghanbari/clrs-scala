package com.clrs.c02

import org.scalatest.{FlatSpec, Matchers}

class MutableInsertionSortTest extends FlatSpec with Matchers {

  "ArrayInsertionSort.sort" should "return a sorted array" in {
    val input = Array(5, 2, 4, 6, 1, 3)
    val output = new MutableInsertionSort[Int]().sort(input)
    output shouldBe sorted
  }

}