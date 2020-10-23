package com.clrs.c08

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ArrayCountingSortTest extends AnyWordSpec with Matchers {

  "ArrayCountingSortTest.countingSort" when {
    "k = 5" should {
      "return a sorted array" in {
        val k      = 5
        val input  = Array(2, 5, 3, 0, 2, 3, 0, 3)
        val output = Array.ofDim[Int](input.length)
        ArrayCountingSort.countingSort(k)(input, output)
        output shouldBe sorted
      }
    }
  }

}
