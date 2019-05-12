package com.clrs.apc

import scala.util.Random

object FairCoin extends Coin {

  override def toss(): Boolean = Random.nextBoolean()

}
