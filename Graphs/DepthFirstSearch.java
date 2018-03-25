public class DepthFirstSearch {
  private boolean[] marked; // marked[v] = is there an s-v path?
  private int count; // number of vertices connected to s

  public DepthFirstSearch(Grahp G, int s) {
    marked = new boolean[G.V()];
    validateVertex(s);
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    count++;
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[W]) {
        dfs(G, w);
      }
    }
  }

  private boolean marked(int v) {
    validateVertex(v);
    return marked[v];
  }

  public int count() {
    return count;
  }

  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    DepthFirstSearch search = new DepthFirstSearch(G, s);
    for (int v = 0; v < G.V(); v++) {
      if (search.marked(v))
        StdOut.print(v + " ");
    }
    StdOut.println();
    if (search.count() != G.V()) StdOut.println("NOT connected");
    else StdOut.println("connected");
  }
}
