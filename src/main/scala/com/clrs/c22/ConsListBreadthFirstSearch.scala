package com.clrs.c22

object ConsListBreadthFirstSearch {

  /**
    * BFS using cons list and fold left. Not tail recursive!
    *
    * @param g Adjacency list graph.
    * @param s source node.
    * @tparam V Parametric type of vertices.
    * @return BFS Traversal.
    */
  def bfs[V](g: AdjacencyListGraph[V])(s: V): List[V] = {
    def iter(visited: List[V], v: V): List[V] =
      if (visited.contains(v)) visited
      else g.adj(v).filterNot(visited.contains).foldLeft(v :: visited)(iter)

    iter(List(), s).reverse
  }

}
