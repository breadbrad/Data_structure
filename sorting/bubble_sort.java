// after one pass, only the last array element must be in its correct place 
// after 2 , the last two array elements ...

// boolean flag exchanges -> to keep track of whether any exchanges were made during the current pass 

/**
initialize exchanges to false
for each pair of adjacent array elements 
        if the values in a pair are out of order
                Exchange the values 
                Set exchanges to true -> Made an exchange, array not sorted(go through while loop)
*/
class BubbleSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
                int pass = 1;
                boolean exchanges = false;
                do {
                        // Invariant: Elements after table.length - pass + 1 are in place
                        exchanges = false;
                        for(int i = 0; i< table.length - pass; i++) {
                                if(table[i].compareTo(table[i+1]) > 0) {
                                        T temp = table[i];
                                        table[i] = table[i+1];
                                        table[i+1] = temp;
                                        exchanges = true;
                                }
                        }
                        pass++;
                } while (exchanges);
        }
}
