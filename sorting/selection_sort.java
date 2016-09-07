class SelectionSort {
        /** pre: table contains Comparable objects
            post: table is sorted
            @param table The array to be sorted
        */

        // http://stackoverflow.com/questions/20938318/sorting-an-array-of-comparable-interface#
        // public static void sort(Comparable[] table) {
           public static <T extends Comparable<T>> void sort(T[] table) {
               int n = table.length;
               for (int fill = 0; fill < n - 1; fill++) {
                        // Invariant : table[0 . . . fill - 1] is sorted
                        int posMin = fill;
                        for (int next = fill + 1; next < n; next++) {
                        // Invariant: table[posMin] is the smallest item in table[fill ... min]
                                if(table[next].compareTo(table[posMin]) < 0) {
                                        posMin = next;
                                }
                        }

                        // assert: table[posMin] is the smallest item in table[fill ... n - 1]
                        // Exchange table[fill] and table[posMin]
                        Comparable temp = table[fill];
                        table[fill] = table[posMin];
                        table[posMin] = temp;
                        // assert: table[fill] is the smallest item in table[fill . . . n - 1]
                }
                // assert: table[0 . . . n - 1] is sorted 
        }
}
