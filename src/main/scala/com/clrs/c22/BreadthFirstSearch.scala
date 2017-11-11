package com.clrs.c22

import scala.collection.mutable.{ArrayBuffer, Map => MutableHashMap}

trait BreadthFirstSearch[V] { self: AdjacencyListGraph[V] =>

  def bfs(s: V): Traversal[V] = {
    val visited = ArrayBuffer(s)
    val level: MutableHashMap[V, Int] = MutableHashMap(s -> 0)
    val parent: MutableHashMap[V, Option[V]] = MutableHashMap(s -> None)
    var i = 1
    var frontier = ArrayBuffer(s)
    while (frontier.nonEmpty) {
      val next = ArrayBuffer.empty[V]
      frontier.foreach { u =>
        adj(u).foreach { v =>
          if (!level.contains(v)) {
            level(v) = i
            parent(v) = Some(u)
            next.append(v)
            visited.append(v)
          }
        }
      }
      frontier = next
      i += 1
    }
    Traversal(visited, level.toMap, parent.toMap)
  }

}

case class Traversal[V](visited: Seq[V], level: Map[V, Int], parent: Map[V, Option[V]])