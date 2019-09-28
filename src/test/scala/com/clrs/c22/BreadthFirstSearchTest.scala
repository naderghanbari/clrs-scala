package com.clrs.c22

import com.clrs.common.SatelliteObject
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BreadthFirstSearchTest extends AnyFlatSpec with Matchers {

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

  val BFS = BreadthFirstSearch.bfs(HashMapAdjacencyListGraph(adj))(_)

  "BreadthFirstSearch" should "return a traversal in the expected order if A is the source node " in {
    val result = BFS(A)
    val expectedVisited = Seq("A", "B", "C", "D", "E")
    result.visited.map(_.key) should contain theSameElementsInOrderAs expectedVisited
    result.level.get(A) should contain(0)
    result.level.get(D) should contain(2)
    result.parent.get(D).flatten should contain(B)
  }

  "BreadthFirstSearch" should "return a traversal in the expected order if F is the source node " in {
    val result = BFS(F)
    val expectedVisited = Seq("F")
    result.visited.map(_.key) should contain theSameElementsInOrderAs expectedVisited
  }

}