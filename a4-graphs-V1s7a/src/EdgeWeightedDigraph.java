import edu.princeton.cs.algs4.Bag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.List;
import java.util.NoSuchElementException;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    private int[] indegree;
    /**
     * Creates a new empty graph with the provided number of nodes
     * @param V The number of nodes that the graph will contain
     */

    /**
     * Creates a new graph data structure from the contents of a file. The format
     * of the file is expected to match the format described in the assignment's
     * README file.
     * @param in The file that will be used to construct the graph
     */
    public EdgeWeightedDigraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
            indegree = new int[V];
            adj = (Bag<DirectedEdge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<DirectedEdge>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                addEdge(v, w, weight);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedDigraph constructor", e);
        }
    }

    public void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new NoSuchElementException("vertex " + v + " is not between 0 and " + (V - 1));


    }

    /**
     *
     * @return The number of nodes in the graph
     */
    public int getV() {
        return this.V;
    }

    /**
     *
     * @return The number of edges in the graph
     */
    public int getE() {
        return this.E;
    }

    /**
     * Returns a Bag containing all of the edges that are adjacent to the provided
     * node ID
     * @param v The id of the node/vertex who's adjacent edges should be returned
     * @return A bag containing all of the edges that are adjacent to V
     * @throws NoSuchElementException when v is not a valid node/vertex ID
     */
    public Bag<DirectedEdge> adjEdges(int v) throws NoSuchElementException {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns a Bag containing all of the verticies that are adjacent to the provided
     * node/vertex ID
     * @param v The id of the node/vertex who's adjacent vertices should be returned
     * @return A bag containing all of the vertices that are adjacent to V
     * @throws NoSuchElementException when v is not a valid node/vertex ID
     */
    public Bag<Integer> adjVertices(int v) throws NoSuchElementException {
        validateVertex(v);
        Bag<Integer> adjVertices = new Bag<>();
        for (DirectedEdge e : adj[v]){
            adjVertices.add(e.to());
        }
        return adjVertices;
    }

    /**
     * Adds a new edge to the graph
     * @param src The source node/vertex ID
     * @param dst The destination node/vertex ID
     * @param weight The weight associated with the edge
     * @throws NoSuchElementException if src or dst are invalid node IDs
     */
    public void addEdge(int src, int dst, double weight) throws NoSuchElementException, IllegalArgumentException {
        validateVertex(src);
        validateVertex(dst);
        DirectedEdge edge = new DirectedEdge(src, dst, weight);
        adj[src].add(edge);
        indegree[dst]++;
        E++;
    }



    /**
     *
     * @return A bag containing all edges in the graph
     */
    public Bag<DirectedEdge> edges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int v = 0; v < V; v++){
            for (DirectedEdge e : adj[v]){
                edges.add(e);
            }
        }
        return edges;
    }

    /**
     * Returns a string representation of this edge-weighted digraph. This method is fully
     * implemented. Do not modify.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists of edges
     */
    public String toString() {
        final String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(getV()).append(" ").append(getE()).append(NEWLINE);
        for (int v = 0; v < getV(); v++) {
            for (DirectedEdge e : adjEdges(v)) {
                s.append(e.toString());
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        StdOut.println(G);
    }


}
