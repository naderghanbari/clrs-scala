package com.clrs.apc

/** Given two numbers `a` and `b`, such that `a < b`, simulates a biased coin such that
  * the probability of `Heads` (represented by True) is `a/b`.
  *
  * Does so by first creating a (possibly infinite) stream of bits in the binary
  * representation of `a / b`.
  */
class FractionalBiasedCoin(a: Long, b: Long)(fair: Coin) extends Coin {
  require(0 < a && a < b, "0 < a < b")

  private val bits =
    LazyList.iterate(a)(_ * 2 % b).takeWhile(_ != 0).map(_ * 2 >= b)

  override def toss(): Boolean =
    bits.zip(Iterator.continually(fair.toss())).collectFirst { case (x, y) if x == y => x }.getOrElse(false)

}
