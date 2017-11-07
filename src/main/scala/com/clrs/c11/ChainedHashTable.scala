package com.clrs.c11

import com.clrs.common.{HasKey, Index}

import scala.reflect.ClassTag

/**
  * Hash table resolving collisions by chaining
  * Chapter 11, Section 11.2, Page 257
  *
  * Instead of a linked list, a cons list is used for chaining which does not affect time and space complexity for
  * search and insert. Delete, though, will not be exactly O(1) like insert, rather it'll be amortized O(1) just like
  * search.
  *
  * @param m Size of the table. Make sure `h` function produces results in the [0, m -1] range.
  * @param h Hash function, h: U -> [0, m -1].
  * @tparam K Type of keys.
  * @tparam X Type of elements. Must have a key that can be used as index.
  */
class ChainedHashTable[K, X <: HasKey[K] : ClassTag](m: Int)(implicit h: HashFunction[K, Index]) {

  private val T = Array.fill(m - 1)(List.empty[X])

  /**
    * Hash table search.
    *
    * @param k Key to lookup.
    * @return Some(value) if h(key) exists in the table, None otherwise.
    */
  def search(k: K): Option[X] = T(h(k)).find(_.key == k)

  /**
    * Hash table insert.
    *
    * @param x Element to insert.
    */
  def insert(x: X): Unit = T(h(x.key)) ::= x

  /**
    * Hash table delete.
    *
    * @param x Element to delete.
    */
  def delete(x: X): Unit = {
    val hash = h(x.key)
    T(hash) = T(hash).filter(_.key != x.key)
  }

}