package com.clrs.c22

import com.clrs.common.SatelliteObject
import org.scalatest.{FlatSpec, Matchers}

class ConsListBreadthFirstSearchTest extends FlatSpec with Matchers {

  val A = SatelliteObject("A", "Node A")
  val B = SatelliteObject("B", "Node B")
  val C = SatelliteObject("C", "Node C")
  val D = SatelliteObject("D", "Node D")
  val E = SatelliteObject("E", "Node E")
  val F = SatelliteObject("F", "Node F")

  val adj = Map(
    A -> Seq(B, C),
    B -> Seq(A, C, D),
    C -> Seq(A, B, D),
    D -> Seq(B, C, E),
    E -> Seq(D),
    F -> Seq()
  )

  val BFS = ConsListBreadthFirstSearch.bfs(HashMapAdjacencyListGraph(adj))(_)

  "ConsListBreadthFirstSearch" should "return a traversal in the expected order if A is the source node " in {
    val result = BFS(A)
    val expectedVisited = Seq("A", "B", "C", "D", "E")
    result.map(_.key) should contain theSameElementsInOrderAs expectedVisited
  }

  "ConsListBreadthFirstSearch" should "return a traversal in the expected order if F is the source node " in {
    val result = BFS(F)
    val expectedVisited = Seq("F")
    result.map(_.key) should contain theSameElementsInOrderAs expectedVisited
  }

}