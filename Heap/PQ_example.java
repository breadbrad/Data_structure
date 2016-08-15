// ComparePrintDocuments 

import java.util.Comparator;

public class ComparePrintDocuments implements Comparator<PrintDocument> {
        // Weight factor for size 
        private static final double P1 = 0.8;
        // Weight factor for time 
        private static final double P2 = 0.2;
        
        public int compare(PrintDocument left, PrintDocument right) {   
                return Double.compare(orderValue(left), orderValue(right));
        }
        
        /** Compute the order value for a print document */ 
        private double orderValue(PrintDocument pd) {
                return P1 * pd.getSize() + P2 * pd.getTime();
        }
}

