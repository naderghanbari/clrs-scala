package com.clrs.c11

/**
  * A hash function
  * Chapter 11, Section 11.3, Page 262
  *
  * @tparam K Type of keys.
  * @tparam H Type of hash values, normally `Int` so that it can be used as an index for addressing.
  */
trait HashFunction[-K, +H] extends (K => H) {

  /**
    * Hash function.
    *
    * @param k Key.
    * @return Hash.
    */
  def hash(k: K): H

  override def apply(k: K): H = hash(k)

}

object HashFunction {

  /**
    * Hash functions, Division method
    * Chapter 11, Section 11.3.1, Page 263
    *
    * @param m Hash range. Resulting hash will be in the range of [0, m-1].
    */
  class DivisionHashFunction(m: Int) extends HashFunction[Int, Int] {
    assert(m > 1)

    override def hash(k: Int) = Math.floorMod(k, m)
  }


  class MultiplicationMethod(m: Int) extends HashFunction[Int, Int] {
    assert(m > 1)
    private val A = 0.6180339887
    private val modOne = (n: Double) => n - Math.floor(n)

    override def hash(k: Int): Int = (m * modOne(k * A)).toInt
  }

}
