package com.clrs.common.binary

object Bit {

  def isBit: Char => Boolean =
    asBit.contains

  def asBit: Char Map Byte =
    Map('0' -> 0, '1' -> 1)

}
