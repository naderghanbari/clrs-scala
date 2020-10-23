package com.clrs.c10.s1.exercises.e10_1_5

/** Exercise 10.1-5
  *
  * Dequeue
  *
  * NOTE array index `0` corresponds to index `1` in the book, and so on.
  *
  * @param n NOTE Same `n` as in the book, i.e. size of the backing array. Capacity of the queue will be n - 1.
  */
class Dequeue(n: Int) {
  assert(n > 1)

  private val Q: Array[Int] = Array.ofDim[Int](n)

  private var head: Int = 0
  private var tail: Int = 0

  def isEmpty: Boolean = head == tail

  def isFull: Boolean = Math.floorMod(head - tail, n) == 1

  /** O(1)
    * Enqueue a new item..
    *
    * @param x New item to be enqueued.
    */
  def enqueue(x: Int): Unit =
    if (isFull) throw new IllegalStateException("Queue overflow")
    else {
      Q(tail) = x
      if (tail == n - 1) tail = 1
      else tail = tail + 1
    }

  /** O(1)
    * Dequeue oldest item in the queue, i.e. head.
    *
    * @return Oldest item in the queue.
    */
  def dequeue(): Int =
    if (isEmpty) throw new IllegalStateException("Stack Underflow")
    else {
      val x = Q(head)
      if (head == n - 1) head = 1
      else head = head + 1
      x
    }

}
