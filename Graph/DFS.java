class DepthFirstSearch {
        private Graph graph;
        /** Array of parents in the dfs tree */
        private int[] parent;
        /** Flag to indicate whether this vertex has been visited */
        private boolean[] visited;
        /** The array that contains each vertex in discovery order */
        private int[] discoveryOrder;
        /** The array that contains each vertex in finish order */ 
        private int[] finishOrder;
        private int discoverIndex = 0;
        private int finishIndex = 0;

        // Constructors 
        /** Construct the dfs of a Graph starting at vertex 0
        and visiting the start vertices in ascending order 
        @param graph The Graph 
        */
        public DepthFirstSearch(Graph graph) {
                this.graph = graph;
                int n = graph.getNumv();
                parent = new int[n];
                visited = new boolean[n];
                discoveryOrder = new int[n];
                finishOrder = new int[n];
                for (int i = 0; i < n; i++) {
                        parent[i] = -1; 
                }
                for (int i = 0; i < n; i++) {
                        if (!visited[i]) 
                                depthFirstsearch(i);
                }
        }

        /** Construct the dfs of a Graph
        selecting the start vertices in the specified order
        The first vertex visited is order[0]
        @param graph The graph
        @param order The array giving the order 
                in which the start vertices shoud be selected 
        */
        public DepthFirstSearch(Graph graph, int[] order) {
                this.graph = graph;
                int n = graph.getNumv();
                parent = new int[n];
                visited = new boolean[n];
                discoveryOrder = new int[n];
                finishOrder = new int[n];
                for (int i = 0; i < n; i++) {
                        parent[i] = -1; 
                }
                for (int i = 0; i < n; i++) {
                         depthFirstsearch(i);
                }
        }

        public void depthFirstSearch(int current) {
                /* Mark the current vertex visited */
                visited[current] = true;
                discoveryOrder[discoverIndex++] = current;
                /* Examine each vertex adjacent to the current vertex */
                Iterator<Edge> itr = graph.edgeIterator(current);
                while (itr.hasNext()) {
                        int neighbor = itr.next().getDest();
                        /* Process a nieghtbor that has not been vistied */
                        if (!visited[neighbor]) {
                                /** Insert (current, neightbor) into the dfs tree */
                                parent[neighbor] = current;
                                /** Recursively apply the algorithm starting at neighbor */
                                depthFirstsearch(neighbor);
                        }
                }
                /* Mark current finished */
                finishOrder[finishIndex++] = current;
        }
}

