package com.clrs.c11

import com.clrs.common.{Index, SatelliteObject}

object DirectAccessTableTest extends App {
  val m = 10
  val table = new DirectAccessTable[SatelliteObject[Index]](m)

  val two = SatelliteObject(2, "Satellite 2")
  val three = SatelliteObject(3, "Satellite 3")
  val five = SatelliteObject(5, "Satellite 5")
  val eight = SatelliteObject(8, "Satellite 8")

  println("SEARCH 2")
  assert(table.search(2).isEmpty)
  println("NIL")

  println(s"INSERT $two")
  table.insert(two)
  println("SEARCH 2")
  assert(table.search(2).contains(two))
  println(two)

  println(s"INSERT $three")
  table.insert(three)
  println(s"INSERT $five")
  table.insert(five)
  println(s"INSERT $eight")
  table.insert(eight)

  println(s"DELETE $five")
  table.delete(five)

  println("SEARCH 5")
  assert(table.search(5).isEmpty)
  println("NIL")
}
