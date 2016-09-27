class TopologicalSort {
        /** arg[0] contains the name of the file that contains the graph (DAG)
        */
        public static void main(String[] args) {
                Graph theGraph = null;
                int numVertices = 0;
                try {
                        Scanner scan = new Scanner(new File(args[0]));
                        theGraph = AbstractGraph.createGraph(scan, true, "List");
                        numVertices = theGraph.getNumV();
                } catch (Exception ex) {
                        ex.printStackTrace();
                        System.exit(1);
                }
                DepthFirstSearch dfs = new DepthFirstSearch(theGraph);
                int[] finishOrder = dfs.getFinishOrder();
                System.out.println("The topological Sort is ");
                for (int i = numVertices - 1; i >= 0; i--) {
                        System.out.println(finishOrder[i]);
                }
        }
}

