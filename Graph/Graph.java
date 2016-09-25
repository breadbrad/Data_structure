import java.util.*;

/** A graph = a set of vertices and a set of edges 
    Vertices = represented by integers from 0 to n-1
    Edges = ordered paris of vertices 
*/

public interface Graph {
        // Accessor methods
        /** Return the number of vertices */
        int getNumv();

        /** Determine whether this is a directed graph */
        boolean isDirected();

        /** Insert a new edge into the graph */
        void insert(Edge edge);

        /**Determine whether an edge exists */
        boolean isEdge(int source, int dest);

        /**Get the edge between two vertices */
        Edge getEdge(int source, int dest);

        /**Return an iterator to the edges connected */
        Interator<Edge> edgeIterator(int source);
}
