package com.clrs.c11

import com.clrs.common.SatelliteObject

object NaiveHastTableTest extends App {
  val m = 10
  implicit val divisionHashFunction = new HashFunction.DivisionHashFunction(m)

  val table = new NaiveHashTable[Int, SatelliteObject[Int]](m)

  val twelve = SatelliteObject(12, "Satellite 12")
  val thirteen = SatelliteObject(13, "Satellite 13")
  val fifteen = SatelliteObject(15, "Satellite1 15")
  val eighteen = SatelliteObject(18, "Satellite 18")

  println("SEARCH 12")
  assert(table.search(12).isEmpty)
  println("NIL")

  println(s"INSERT $twelve")
  table.insert(twelve)
  println("SEARCH 12")
  assert(table.search(12).contains(twelve))
  println(twelve)

  println(s"INSERT $thirteen")
  table.insert(thirteen)
  println(s"INSERT $fifteen")
  table.insert(fifteen)
  println(s"INSERT $eighteen")
  table.insert(eighteen)

  println(s"DELETE $fifteen")
  table.delete(fifteen)

  println("SEARCH 15")
  assert(table.search(15).isEmpty)
  println("NIL")
}
