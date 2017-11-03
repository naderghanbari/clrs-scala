package com.clrs.c10.s1

object StackTest extends App {
  val s = new Stack(2)
  assert(s.isEmpty, "Stack must be empty initially")
  assert(!s.isFull, "Stack must be not full initially")

  println("PUSH 42")
  s.push(42)

  assert(!s.isEmpty, "Stack must be non-empty now")
  assert(!s.isFull, "Stack must be still not full")

  println("POP")
  val `42` = s.pop()
  assert(`42` == 42, "Popped item does not match last pushed item")
  println(`42`)
}