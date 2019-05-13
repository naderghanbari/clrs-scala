package com.clrs.apc

/** Given two numbers `a` and `b`, such that `a < b`, simulates a biased coin such that
  * the probability of `Heads` (represented by True) is `a/b`.
  *
  * Does so by first creating a (possibly infinite) stream of bits in the binary
  * representation of `a / b`.
  */
class FractionalBiasedCoin(a: Long, b: Long) extends Coin {
  require(0 < a && a < b, "0 < a < b")

  val bits   = LazyList.iterate(a)(_*2 % b).takeWhile(0.!=).map(_*2 >= b)
  def fairs  = Iterator.continually(FairCoin.toss())
  def toss() = bits.zip(fairs).find(Function.tupled(_==_)).exists(_._1)
}
