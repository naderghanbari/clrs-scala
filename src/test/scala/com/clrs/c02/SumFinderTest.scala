package com.clrs.c02

import org.scalatest.{Matchers, OptionValues, WordSpec}

class SumFinderTest extends WordSpec with Matchers with OptionValues {

  "Sum Finder" should {

    "find pair of elements by their sum" in {
      val set    = Set(1, 4, 8, 10)
      val sum    = 12
      val result = SumFinder.findBySum(set, sum)
      result.value shouldBe (4, 8)
    }

    "find the pair the most apart by their sum" in {
      val set    = Set(1, 2, 3, 4, 5, 6, 7, 8, 30, 31, 32, 40, 50, 60, 70, 80)
      val sum    = 35
      val result = SumFinder.findBySum(set, sum)
      result.value shouldBe (3, 32)
    }

    "return None if no pair adds up to the given sum" in {
      val set    = (0 to 100 by 2).toSet
      val sum    = 15
      val result = SumFinder.findBySum(set, sum)
      result shouldBe empty
    }

  }

}
