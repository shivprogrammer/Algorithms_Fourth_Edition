public class Graph {
  private static final String NEWLINE = System.getProperty("line.separator");

  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  // Initialize empty graph

  public Graph(int v) {
    if (V < 0) throw new IllegalArgumentExecption("Number of vertices must be nonnegative");
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[] new Bag[V]);
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<Integer>();
    }
  }
}
