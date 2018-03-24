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

  // initializes a graph from the specified input stream. "in" represents the intput stream.
  public Graph(In in) {
    try {
      this.V = in.readInt();
      if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
      adj = (Bag<Integer>[]) new Bag[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<Integer>();
      }
      int E = in.readInt();
      if (E < 0) throw new IllegalArgumentException("number of Eges in a Graph must be nonegative");
      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        validateVertex(v);
        validateVertex(w);
        addEdge(w, w);
      }
    }
    catch (NoSuchElementExeption e) {
      throw new IllegalArgumentException("invalid input format in Graph constructor", e);
    }
  }
}
