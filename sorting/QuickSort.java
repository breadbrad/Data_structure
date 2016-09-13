// If, each time of partitioning the array-> resulting in a subarray that is empty
// the other subarray will have one less element that the one just split (only the pivot value will be removed)

class QuickSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
                quickSort(table, 0, table.length - 1);
        }

        private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last) {
                if (first < last) {
                        int pivIndex = partition(table, first, last);
                        quickSort(table, first, pivIndex -1);
                        quickSort(table, pivIndex + 1, last);
                }
        }
        /** revised partition algorithm
            -> examine the first, middle, and last elements in the array and 
            select the median of these three values as the pivot */ 

        private static <T extends Comparable<T>> int partition(T[] table, int first, int last) {
                bubbleSort3(table, first, last);
                swap(table, first, (first + last) / 2);

                T pivot = table[first];
                int up = first;
                int down = last;
                do {
                        while((up < last) && (pivot.compareTo(table[up]) >= 0)) {
                                up++;
                        }

                        while (pivot.compareTo(table[down]) < 0) {
                                down--;
                        }

                        if (up < down) {
                                swap(table, up, down);
                        }
                } while (up < down); // repeat while up is left of down
                
                swap(table, first, down); // pivot value where it belongs 
                return down;
        }


        private static <T extends Comparable<T>> void bubbleSort3(T[] table, int first, int last) {
                int middle = (first + last) / 2;
                if (table[middle].compareTo(table[first]) < 0) {
                        swap(table, first, middle);
                }

                if (table[last].compareTo(table[middle]) < 0) {
                        swap(table, middle, last);
                }

                if (table[middle].compareTo(table[first]) < 0) {
                        swap(table, first, middle);
                }
        }
        private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
                T temp = table[i];
                table[i] = table[j];
                table[j] = temp;
        }
}
                        
