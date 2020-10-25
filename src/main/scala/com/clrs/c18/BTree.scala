package com.clrs.c18

import com.clrs.common.{HasKey, Index}

import scala.annotation.tailrec
import scala.reflect.ClassTag
import scala.math.Ordering.Implicits.infixOrderingOps

/** Mutable in-memory B-Tree backed by arrays
  * Chapter 18, Section 18.1, Page 488
  *
  * @param t Min degree of the B0tree.
  * @tparam K Type of keys.
  * @tparam E Type of elements. Must have a key of type K.
  */
class BTree[K: Ordering, E <: HasKey[K]: ClassTag] private (t: Int) {

  val root: Node = allocateNode(leaf = true)

  /** A node of a B-tree
    * Section 18.1 Page 288
    *
    * @param n Number of elements currently stored in this node.
    * @param leaf True if this node is a leaf and false if is an internal node.
    * @param elems Elements stored at this node (key + satellite data).
    * @param children Pointers to children.
    */
  class Node(
    var n: Int,
    var leaf: Boolean,
    val elems: Array[E],
    val children: Array[Node],
  )

  /** Search by key starting from node x.
    * Section 18.2, Page 492
    *
    * @param k Key to lookup.
    * @return Some(value) if an entry with given key exists in the tree, None otherwise.
    */
  @tailrec final def search(x: Node, k: K): Option[(Node, E, Index)] = {
    var i = 0
    while ((i + 1 <= x.n) && (k > x.elems(i).key))
      i += 1
    if ((i + 1 <= x.n) && (k == x.elems(i).key))
      Some((x, x.elems(i), i))
    else if (x.leaf)
      None
    else
      search(x.children(i), k)
  }

  private def allocateNode(leaf: Boolean): Node = {
    new Node(
      n = 0,
      leaf = leaf,
      elems = Array.fill(2 * t - 1)(null.asInstanceOf[E]),
      children = Array.fill(2 * t)(null),
    )
  }

  private def splitChild(x: Node, i: Index): Unit = {
    val y = x.children(i)
    val z = allocateNode(leaf = y.leaf)
    z.n = t - 1
    for (j <- 0 until (t - 1))
      z.elems(i) = y.elems(j + t)
    if (!y.leaf)
      for (j <- 0 until t)
        z.children(j) = y.children(j + t)
    y.n = t - 1
    for (j <- x.n to i by -1)
      x.children(j + 1) = x.children(j)
    x.children(i + 1) = z
    for (j <- (x.n - 1) until i by -1)
      x.elems(j + 1) = x.elems(j)
    x.elems(i) = y.elems(t)
    x.n += 1
  }
}

object BTree {

  /** Creates an empty B-tree
    * Chapter 18, Section 18.2, Page 492
    *
    * @param t Min degree of the B0tree.
    * @tparam K Type of keys.
    * @tparam E Type of elements. Must have a key of type K.
    * @return Empty B-tree of min-degree t.
    */
  def create[K: Ordering, E >: Null <: HasKey[K]: ClassTag](t: Int): BTree[K, E] = {
    require(t >= 2, "Minimum degree of a B-tree must be at least 2 (page 489)")
    new BTree[K, E](t)
  }

}
