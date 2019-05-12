package com.clrs.apc

import org.scalatest.WordSpec

class FractionalBiasedCoinTest extends WordSpec {

  "FractionalBiasedCoin" should {
    "work properly" in {
      val (a, b) = (1, 99)
      val headLover = new FractionalBiasedCoin(a, b)(FairCoin)
      val n = 100000
      val sample = List.fill(n)(headLover.toss())
      val estimate = sample.count(identity)
      println(estimate * b)
      println(n * a)
    }
  }

}
