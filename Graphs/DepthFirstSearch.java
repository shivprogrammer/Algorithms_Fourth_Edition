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

  
}
