package com.clrs.common

package object binary {

  sealed abstract class Bit(val v: Int)
  case object `0` extends Bit(0)
  case object `1` extends Bit(1)

  case object Bit {
    def of(value: Int) = value match {
      case 0 => `0`
      case 1 => `1`
    }
  }

  type Binary = Iterable[Bit]

}
