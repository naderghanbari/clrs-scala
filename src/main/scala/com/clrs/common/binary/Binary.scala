package com.clrs.common.binary

case class Binary(bits: Seq[Byte]) {

  lazy val intValue: Long =
    bits.reverse.map(_.toLong).lazyZip(Binary.powersOfTwo).map(_ * _).sum

  def +(that: Binary): Binary =
    Binary {
      val res =
        bits.reverse
          .zipAll(that.bits.reverse, 0.toByte, 0.toByte)
          .scanLeft(0.toByte -> 0.toByte) {
            case ((_, carry), (x, y)) =>
              val sum = x + y + carry
              (sum % 2).toByte -> (sum / 2).toByte
          }
          .drop(1)
          .reverse
      (res.head._2 +: res.map(_._1)).dropWhile(_ == 0)
    }

  override def toString: String =
    bits.mkString("")

}

object Binary {

  val powersOfTwo: LazyList[Long] =
    LazyList.iterate(1L)(_ * 2)

  def apply(s: String): Binary = {
    require(s.forall(Bit.isBit))
    Binary(s.map(Bit.asBit).dropWhile(_ == 0))
  }
}
