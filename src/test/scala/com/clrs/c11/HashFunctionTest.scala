package com.clrs.c11

import com.clrs.c11

object HashFunctionTest extends App {
  val m = 10
  val divisionHashFunction = new HashFunction.DivisionHashFunction(m)
  println(s"DIVISION METHOD h(k) = k mod $m")

  assert(divisionHashFunction(9) == 9)
  println(s"h(9) ${divisionHashFunction(9)}")

  assert(divisionHashFunction(4) == 4)
  println(s"h(4) ${divisionHashFunction(4)}")

  val multiplicationHashFunction = new c11.HashFunction.MultiplicationMethod(m)
  println(s"DIVISION METHOD h(k) = k mod $m")

  println(s"h(9) ${multiplicationHashFunction(100)}")
  println(s"h(9) ${multiplicationHashFunction(9)}")
}
