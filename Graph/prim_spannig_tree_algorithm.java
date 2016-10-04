/** Prims' Minimum Spanning Tree algorithm
        @param graph The weighted graph to be searched 
        @param start The start vertex 
        @return An ArrayList of edges that forms the MST
*/

public static ArrayList<Edge> primsAlgorithm(Graph graph, int start) {
        ArrayList<Edge> result = new ArrayList<Edge>();
        int numV = graph.getNumV();
        // Use a HashSet to represent V-S
        Set<Integer> vMinusS = new HashSet<Integer>(numV);
        // Declare the priority queue
        Queue<Edge> pQ = new PriorityQueue<Edge>(numV, new CompareEdges());
        // Initialize V-S
        for (int i =0; i < numV; i++) {
                if (i != start) {
                        vMinusS.add(i);
                }
        }
        int current = start;
        // Main Looop
        while(vMinusS.size() != 0) {
                // Update priority queue
                Iterator<Edge> iter = graph.edgeIterator(current);
                while (iter.hasNext()) {
                        Edge edge = iter.next();
                        int dest = edge.getDest();
                        if (vMinusS.contains(dest)) {
                                pQ.add(edge);
                        }
                }
                // Find the shortest edge whose sources is in S and destination is in V-S
                int dest = -1;
                Edge edge = null;
                do {
                        edge = pQ.remove();
                        dest = edge.getDest();
                } while(!vMinusS.contains(dest));
                vMinusS.remove(dest);
                result.add(edge);
                //Male this the current vertex.
                current = dest;
        }
        return result;
}

