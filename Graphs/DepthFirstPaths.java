// The DepthFirstPaths class represents a data type for finding paths from a source vertex s to ever other vertex in an undirected graph.

public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  // Computes a path between s and every other vertex in the graph
  public DepthFirstPaths(Graph G, int s) {
    this.s = s;
    edgeTo = new int[G.V()];
    marked = new boolean[G.V()];
    validateVertex(s);
    dfs(G, s);
  }

  // depth first search from v
  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }

  // Is there a path between the source vertex s and vertex v?
  public boolean hasPathTo(int v) {
    validateVertex(v);
    return marked[v];
  }
}
