package com.clrs.c08

import com.clrs.common.SatelliteObject
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

object ConsListCountingSortTest extends AnyWordSpec with Matchers {

  "ConsListCountingSortTest.countingSort" when {
    "k = 5" should {
      "return a sorted cons list" in {
        val k = 5
        val input = List(
          SatelliteObject(2, "First 2"),
          SatelliteObject(5, "First 5"),
          SatelliteObject(3, "First 3"),
          SatelliteObject(0, "First 0"),
          SatelliteObject(2, "Second 2"),
          SatelliteObject(3, "Second 3"),
          SatelliteObject(0, "Second 0"),
          SatelliteObject(3, "Second 3"),
        )
        val output = ConsListCountingSort.countingSort(k)(input)
        output shouldBe sorted
      }
    }
  }

}
