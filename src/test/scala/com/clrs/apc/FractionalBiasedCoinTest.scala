package com.clrs.apc

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FractionalBiasedCoinTest extends AnyWordSpec with Matchers {

  "FractionalBiasedCoin" when {
    "hugely in favor of heads" should {

      val (a, b) = (95, 100)
      val p      = a / b.toDouble

      "work properly" in {
        val headLover = new FractionalBiasedCoin(a, b)
        val n         = 1000000
        val sample    = (Iterator fill n)(headLover.toss())
        val heads     = sample count identity
        heads / n.toDouble shouldEqual p +- (p * (1 - p) / 50)
      }
    }
  }

}
