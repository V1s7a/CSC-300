import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class DijkstraSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    /**
     * Computes a shortest-paths tree from the source vertex to every other
     * vertex in the edge-weighted digraph G.
     *
     * @param  G the edge-weighted digraph
     * @param  s the source vertex
     * @throws IllegalArgumentException if an edge weight is negative
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        for (DirectedEdge e : G.edges()) {
            if (e.weight() < 0) {
                throw new IllegalArgumentException("edge " + e + " has negative weight");
            }
        }

        distTo = new double[G.getV()];
        edgeTo = new DirectedEdge[G.getV()];

        G.validateVertex(s);

        for (int v = 0; v < G.getV(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        pq = new IndexMinPQ<>(G.getV());
        pq.insert(s, distTo[s]);

        while (!pq.isEmpty()) {
            int v = pq.delMin();

            for (DirectedEdge e : G.edges()) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not valid");
    }

    /**
     * Returns the length of a shortest path from the source vertex s to vertex v.
     * @param  v the destination vertex
     * @return the length of a shortest path from the source vertex s to vertex v;
     *         Double.POSITIVE_INFINITY if no such path
     * @throws IllegalArgumentException unless 0 <= v < V
     */
    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    /**
     * Returns true if there is a path from the source vertex s to vertex v.
     *
     * @param  v the destination vertex
     * @return true if there is a path from the source vertex
     *         s to vertex v; false otherwise
     * @throws IllegalArgumentException unless 0 <= v < V
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * Returns a shortest path from the source vertex s to vertex v.
     *
     * @param  v the destination vertex
     * @return a shortest path from the source vertex s to vertex v
     *         as an iterable of edges, and null if no such path
     * @throws IllegalArgumentException unless 0 <= v < V
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Bag<DirectedEdge> path = new Bag<>();

        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.add(e);
        }

        return path;
    }

    /**
     * Unit tests the DijkstraSP data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = Integer.parseInt(args[1]);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.getV(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f):\n", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print("\t"+e);
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d no path\n", s, t);
            }
        }
    }

}
