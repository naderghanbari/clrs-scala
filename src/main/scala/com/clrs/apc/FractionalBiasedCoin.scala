package com.clrs.apc

import scala.Function.tupled

/** Appendix C, Exercise C.2-6, Page 1195
  *
  * Given two numbers `a` and `b`, such that `a < b`, simulates a biased coin such that
  * the probability of `Heads` (represented by True) is `a/b`.
  *
  * Does so by first creating a (possibly infinite) stream of bits in the binary
  * representation of `a / b`.
  */
class FractionalBiasedCoin(a: Long, b: Long) extends Coin {
  require(0 < a && a < b, "0 < a < b")

  private val bits = LazyList.iterate(a)(_ * 2 % b).takeWhile(0.!=).map(_ * 2 >= b)

  private def fairs = Iterator.continually(FairCoin.toss())

  override def toss(): Boolean = bits.zip(fairs).find(tupled(_ == _)).exists(_._1)

}
