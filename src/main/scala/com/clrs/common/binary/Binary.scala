package com.clrs.common.binary

/** A binary non/fractional number.
  *
  * @param bits Bits, starting from least significant to most significant.
  */
case class Binary private (bits: Seq[Byte]) {

  lazy val longValue: Long =
    bits.reverse.map(_.toLong).lazyZip(Binary.powersOfTwo).map(_ * _).sum

  def +(that: Binary): Binary =
    Binary {
      val res =
        bits.reverse
          .zipAll(that.bits.reverse, 0.toByte, 0.toByte)
          .scanLeft(0.toByte -> 0.toByte) { case ((_, carry), (x, y)) =>
            val sum = x + y + carry
            (sum % 2).toByte -> (sum / 2).toByte
          }
          .drop(1)
      (res.head._2 +: res.map(_._1)).dropWhile(_ == 0)
    }

  override def toString: String =
    bits.mkString("")

}

object Binary {

  val B0: Byte = 0
  val B1: Byte = 1

  val powersOfTwo: LazyList[Long] =
    LazyList.iterate(1L)(_ * 2)

  def from(s: String): Binary = {
    require(s.forall(Bit.isBit))
    Binary(s.map(Bit.asBit).dropWhile(_ == 0))
  }

  def from(n: Long): Binary =
    Iterator
      .iterate((n, List.empty[Byte])) { case (m, bits) => (m / 2, (m % 2).toByte :: bits) }
      .collectFirst { case (0, bits) => Binary(bits) }
      .get

  def apply(bits: Seq[Byte]): Binary = {
    val withoutZeros = bits.dropWhile(_ == B0)
    new Binary(if (withoutZeros.isEmpty) Seq(B0) else withoutZeros)
  }

}
