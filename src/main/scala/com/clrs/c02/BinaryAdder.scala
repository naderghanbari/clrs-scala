package com.clrs.c02

import com.clrs.common.binary._

/** Binary adder.
  *
  * Chapter 2, Section 2.1, Exercise 2.1-4, Page 22
  */
object BinaryAdder {

  def add(a: Binary, b: Binary): Binary =
    a.zipAll(b, `0`, `0`)
      .scanLeft[(Bit, Bit)](`0` -> `0`) {
        case ((_, carry), (x, y)) =>
          val sum = x.v + y.v + carry.v
          Bit.of(sum % 2) -> Bit.of(sum / 2)
      }
      .drop(1)
      .map(_._1)

}
