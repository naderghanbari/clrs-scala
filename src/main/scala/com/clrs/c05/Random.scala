package com.clrs.c05

import com.clrs.common.binary.Binary

/** Chapter 5, Section 1
  *
  * Integer random generator.
  */
object Random {

  private val underlying = new scala.util.Random()

  /** Exercise 5.1-2, page 117, variant 1.
    *
    * Runs in O(b -a), which is super slow for large ranges.
    *
    * @param a Lower inclusive bound.
    * @param b Upper inclusive bound, must be greater than or equal to a.
    * @return A random integer in the range [a, b]
    */
  def slow(a: Int, b: Int): Int = (a, b) match {
    case (0, 1)           => if (underlying.nextBoolean()) 1 else 0
    case (a, b) if b >= a => Iterator.fill(b - a)(slow(0, 1)).sum + a
    case _                => throw new IllegalArgumentException(s"a must be <= b but a=$a and b=$b were given!")
  }

  /** Exercise 5.1-2, page 117, variant 2.
    *
    * Runs in O(log(b - a)), which for a fixed integer range is O(1).
    *
    * @param a Lower inclusive bound.
    * @param b Upper inclusive bound, must be greater than or equal to a.
    * @return A random integer in the range [a, b]
    */
  def apply(a: Int, b: Int): Int = (a, b) match {
    case (0, 1) =>
      if (underlying.nextBoolean()) 1 else 0
    case (a, b) if b >= a =>
      val d      = b.toLong - a.toLong
      val digits = Binary.from(d).bits.length
      Iterator
        .continually { Seq.fill(digits)(apply(0, 1).toByte) }
        .map(Binary(_).longValue)
        .take(10)
        .find(_ <= d)
        .map(_.toInt + a)
        .get
    case _ =>
      throw new IllegalArgumentException(s"a must be <= b but a=$a and b=$b were given!")
  }

}
