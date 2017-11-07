package com.clrs.c11

import com.clrs.common.{HasKey, Index}

import scala.reflect.ClassTag

/**
  * Hash table resolving collisions by simply overwriting
  * Chapter 11, Section 11.2, Page 256
  *
  * @param m Size of the table. Make sure `h` function produces results in the [0, m -1] range.
  * @param h Hash function, h: U -> [0, m -1].
  * @tparam K Type of keys.
  * @tparam X Type of elements. Must have a key that can be used as index.
  */
class NaiveHashTable[K, X <: HasKey[K] : ClassTag](m: Int)(implicit h: HashFunction[K, Index]) {

  type Entry = Option[X]
  private val T = Array.fill[Entry](m - 1)(None)

  /**
    * Hash table search.
    *
    * @param k Key to lookup.
    * @return Some(value) if h(key) exists in the table, None otherwise.
    */
  def search(k: K): Entry = T(h(k)).filter(_.key == k)

  /**
    * Hash table insert.
    *
    * @param x Element to insert.
    */
  def insert(x: X): Unit = T(h(x.key)) = Some(x)

  /**
    * Hash table delete.
    *
    * @param x Element to delete.
    */
  def delete(x: X): Unit = T(h(x.key)) = None

}