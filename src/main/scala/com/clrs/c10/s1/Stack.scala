package com.clrs.c10.s1

/**
  * Stack of n integers backed by an array.
  *
  * NOTE array index `0` corresponds to index `1` in the book, and so on.
  *
  * @param n Total capacity of the stack.
  */
class Stack(n: Int) {
  assert(n > 0)

  private val S: Array[Int] = Array.ofDim[Int](n)
  private var top: Int = -1

  def isEmpty: Boolean = top == -1

  def isFull: Boolean = top == n - 1

  /**
    * O(1)
    * Pushes a new item to the stack.
    *
    * @param x New item to be pushed to the stack.
    */
  def push(x: Int): Unit =
    if (isFull) throw new IllegalStateException("Stack Overflow")
    else {
      top = top + 1
      S(top) = x
    }

  /**
    * O(1)
    * Pops the topmost item and return it.
    *
    * @return Topmost item.
    */
  def pop(): Int =
    if (isEmpty) throw new IllegalStateException("Stack Underflow")
    else {
      top = top - 1
      S(top + 1)
    }

}
