package com.clrs.c22

/**
  * Adjacency List Representation of a Graph (directed or undirected)
  * Chapter 22, Section 22.1, Page 590
  *
  * This is an implicit representation, in the sense that `adj` is actually a generating function.
  *
  * @tparam V Parametric type of vertices.
  */
trait AdjacencyListGraph[V] {

  /**
    * Adjacency function, adj(vi) = { vj | vi -> vj } for directed graph
    * or adj(vi) = { vj | vi <-> vj } for undirected graph.
    */
  def adj: V => Seq[V]

}

/**
  * An immutable implementation of adjacency list graphs using a hash map.
  * Note that type `Map` in Scala extends type `Function2`. What this means is that you can use a
  * map as a function, just as in it mathematical sense.
  *
  * @param adj Adjacency list map.
  * @tparam V Parametric type of vertices.
  */
case class HashMapAdjacencyListGraph[V](adj: V Map Seq[V]) extends AdjacencyListGraph[V]

/**
  * A generating adjacency list graph, one which given a vertex generates all its neighbors.
  *
  * @param adj Generating function.
  * @tparam V Parametric type of vertices.
  */
case class GeneratingAdjacencyListGraph[V](adj: V => Seq[V]) extends AdjacencyListGraph[V]

/**
  * A lazy generating adjacency list graph, one which given a vertex generates all its neighbors as a stream.
  *
  * @param adj Generating function.
  * @tparam V Parametric type of vertices.
  */
case class LazyAdjacencyListGraph[V](adj: V => Stream[V]) extends AdjacencyListGraph[V]
