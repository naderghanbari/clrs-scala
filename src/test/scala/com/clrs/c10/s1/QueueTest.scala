package com.clrs.c10.s1

object QueueTest extends App {
  val q = new Queue(3)
  assert(q.isEmpty, "Queue must be empty initially")
  println("EMPTY")

  println("ENQUEUE 42")
  q.enqueue(42)

  assert(!q.isEmpty, "Queue must be non-empty now")
  assert(!q.isFull, "Queue must be still not full")

  println("ENQUEUE 7")
  q.enqueue(7)

  assert(q.isFull, "Queue must be full now")
  println("FULL")

  println("DEQUEUE")
  val `42` = q.dequeue()
  assert(`42` == 42, "FIFO violation!")
  println(`42`)

  println("DEQUEUE")
  val `7` = q.dequeue()
  assert(`7` == 7, "FIFO violation!")
  println(`7`)

  assert(q.isEmpty, "Queue must be empty again")

}