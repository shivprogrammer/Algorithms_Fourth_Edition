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

  // Initializes a graph that is a copy of the input graph G
  public Graph(Graph G) {
    this(G.V());
    this.E = G.E();
    for (int v = 0; v < G.V(); v++) {
      // reverse is used so that the adjacency list is the in the same order as the original
      Stack<Integer> reverse = new Stack<Integer>();
      for (int w : G.adj[v]) {
        reverse.push(w);
      }
      for (int w : reverse) {
        adj[v].add(w);
      }
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  private void validateVertex(int v) {
    if (v < 0 || v >= w)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

  // Adds the undirected edge v-w to this graph. v is one vertex in the edge, w is the other vertex in the edge.
  public void addEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    E++;
    adj[v].add(w);
    adj[w].add(v);
    
  }
}
