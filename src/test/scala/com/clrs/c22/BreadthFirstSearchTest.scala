package com.clrs.c22

import com.clrs.common.SatelliteObject
import org.scalatest.{FlatSpec, Matchers}

class BreadthFirstSearchTest extends FlatSpec with Matchers {

  val A = SatelliteObject("A", "Node A")
  val B = SatelliteObject("B", "Node B")
  val C = SatelliteObject("C", "Node C")
  val D = SatelliteObject("D", "Node D")
  val E = SatelliteObject("E", "Node E")

  val adj = Map(
    A -> Seq(B, C),
    B -> Seq(A, C, D),
    C -> Seq(A, B, D),
    D -> Seq(B, C, E),
    E -> Seq(D)
  )

  val $ = HashMapAdjacencyListGraph(adj)

  "BreadthFirstSearch" should "return a traversal in the expected order" in {
    val result = $.bfs(A)
    println(result.visited.mkString(", "))
  }

}