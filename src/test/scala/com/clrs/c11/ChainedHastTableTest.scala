package com.clrs.c11

import com.clrs.common.SatelliteObject

object ChainedHastTableTest extends App {
  val m = 10

  implicit val divisionHashFunction = new HashFunction.DivisionHashFunction(m)

  val table = new ChainedHashTable[Int, SatelliteObject[Int]](m)

  val twelve    = SatelliteObject(12, "Satellite 12")
  val eighteen  = SatelliteObject(18, "Satellite 18")
  val twentyTwo = SatelliteObject(22, "Satellite 22")
  val thirtyTwo = SatelliteObject(32, "Satellite1 32")

  println("SEARCH 12")
  assert(table.search(12).isEmpty)
  println("NIL")

  println(s"INSERT $twelve")
  table.insert(twelve)
  println("SEARCH 12")
  assert(table.search(12).contains(twelve))
  println(twelve)

  println(s"INSERT $twentyTwo")
  println(s"INSERT $eighteen")
  table.insert(eighteen)
  table.insert(twentyTwo)
  println(s"INSERT $thirtyTwo")
  table.insert(thirtyTwo)

  println(s"DELETE $thirtyTwo")
  table.delete(thirtyTwo)

  println("SEARCH 15")
  assert(table.search(5).isEmpty)
  println("NIL")
}
