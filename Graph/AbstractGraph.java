import java.util.*;
import java.io.*;

public abstract class AbstractGraph implements Graph {
        /** number of vertices */
        private int numV;

        /** Flag to indiacte whether this is a directed graph */
        private boolean directed;

        /** Constructor
            @param numV The number of vertices
            @param directed or not
        */
        public AbstractGraph(int numV, boolean directed) {
                this.numV = numV;
                this.directed = directed;
        }

        public int getNumV() {
                return numV;
        }

        public boolean isDirected() {
                return directed;
        }
        
        public void loadEdgesFromFile(Scanner scan) {
                int numV = scan.nextInt();
                AbstractGraph returnValue = null;
                if (type.equalsIgnoreCase("Matrix"))
                        returnValue = new MatrixGraph(numV, isDirected);
                else if (type.equalsIgnoreCase("List"))
                        returnValue = new ListGraph(numV, isDirected);
                else 
                        throw new IllegalArgumentException();
                returnValue.loadEdgesFromFile(scan);
                eturn returnValue;
        }
}
