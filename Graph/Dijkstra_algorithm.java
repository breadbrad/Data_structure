/**Implementation of Dijkstra's algorithm using Hashset and vMinusS (V-S)*/

/** For using an adjacency list representation,
    code below is to iterate through the edges adjacent to vertex u,
    and then update the distance if the destination vertex was in vMinusS*/
// Update the distances 
Iterator<Edge> edgeIter = graph.edgeIterator(u);
while (edgeIter.hasNext()) {
        Edge edge = edgeIter.next();
        int v = edge.getDest();
        if (vMinusS.contains(new Integer(v)))
                double weight = edge.getWeight();
                if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                }
        }
}

/** Dijkstra's Shortest-Path algorithm
    @param graph The weighted graph to be searched 
    @param start the start vertex 
    @param pred Output array to contain the predecessors in the SP
    @param dist Output array to contain the distance in the SP
*/
public static void diskstraAlgorithm(Graph graph, int start, int[] pred, double[] dist) {
        int numV = graph.getnumV();
        HashSet<Integer> vMinusS = new Hashset<Integer>(numV);
        // Initialize V-S
        for (int i = 0; i < numV; i++) {
                if (i != start)
                        vMinusS.add(i);
                }
        }
        // Initialize pred and dist 
        for (int v : vMinusS) {
                pred[v] = start;
                dist[v] = graph.getEdge(start, v).getWeight();
        }
        // Main loop
        while (vMinusS.size() != 0) {
                // Find the value u in V-S with the smallest dist[u]
                double minDist = Double.POSITIVE_INFINITY;
                int u = -1;
                for (int v : vMinusS) {
                        if (dis[v] < minDest) {
                                minDist = dist[v];
                                u = v;
                        }
                }
                // Remove u from vMinusS
                vMinusS.remove(u);
                // Update the distances 
                for (int v : vMinusS) {
                        if (graph.isEdge(u, v)) {
                                double weight = graph.getEdge(u,v).getWeight();
                                if (dist[u] + weight < dist[v]) {
                                        dist[v] = dist[u] + weight;
                                        pred[v] = u;
                                }
                        }
                }
        }
}

