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

  // returns a path between the source vertex s and vertex v
  public Iterable<Integer> pathTo(int v) {
    validateVertex(v);
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeto[x])
      path.push(x);
    path.push(s);
    return path;
  }

  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    int s = Integer.parseInt(args[1]);
    DepthFirstPaths dfs = new DepthFirstPaths(G, s);

    for (int v = 0; v < G.V(); v++) {
      if (dfs.hasPathTo(v)) {
        StdOut.printf("%d to %d: ", s, v);
        for (int x : dfs.pathTo(v)) {
          if (x == s) StdOut.print(x);
          else        StdOut.print("-" + x);
        }
        StdOut.println();
      }
      else {
        StdOut.printf("%d to %d: not connected\n", s, v);
      }
    }
  }
}
