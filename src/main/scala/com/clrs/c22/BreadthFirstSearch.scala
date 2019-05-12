package com.clrs.c22

import scala.annotation.tailrec
import scala.collection.Seq
import scala.collection.mutable.{ArrayBuffer, Map => MutableHashMap}

object BreadthFirstSearch {

  /**
    * Represents a traversal suitable for an imperative style BFS.
    *
    * @param visited Visited nodes.
    * @param level   Level map.
    * @param parent  Parent map.
    * @tparam V Parametric type of vertices.
    */
  case class Traversal[V](visited: Seq[V], level: Map[V, Int], parent: Map[V, Option[V]])

  /**
    * BFS using mutable array buffers and mutable hash maps.
    * Instead of a while loop, a tail recursive closure is being used.
    *
    * @param g Adjacency list graph.
    * @param s source node.
    * @tparam V Parametric type of vertices.
    * @return BFS Traversal.
    */
  def bfs[V](g: AdjacencyListGraph[V])(s: V): Traversal[V] = {
    val visited = ArrayBuffer(s)
    val level = MutableHashMap(s -> 0)
    val parent = MutableHashMap(s -> Option.empty[V])
    val visit = (i: Int, p: V) => (curr: V) => {
      level(curr) = i
      parent(curr) = Some(p)
      visited.append(curr)
      curr
    }

    @tailrec
    def iter(i: Int, front: Seq[V]): Unit =
      if (front.nonEmpty) iter(i + 1, front.flatMap(u => g.adj(u).filterNot(level.contains).map(visit(i, u))))

    iter(1, ArrayBuffer(s))
    Traversal(visited, level.toMap, parent.toMap)
  }

}
