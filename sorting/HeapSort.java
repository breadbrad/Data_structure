class HeapSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
                buildHeap(table);
                shrinkHeap(table);
        }

        private static <T extends Comparable<T>> void buildHeap(T[] table) {
                int n = 1; 
                while (n < table.length) {
                        n++;
                        int child = n - 1;
                        int parent = (child - 1) / 2; // Find parent
                        while (parent >= 0 && table[parent].compareTo(table[child]) < 0) {
                                swap(table, parent, child);
                                child = parent;
                                parent = (child - 1) / 2;
                        }
                }
        }

        private static <T extends Comparable<T>> void shrinkHeap(T[] table) {
                int n = table.length;
                while(n > 0) {
                        n--;
                        swap(table, 0, n);
                        int parent = 0;
                        while (true) {
                                int leftChild = 2 * parent + 1;
                                if (leftChild >= n) {
                                        break; // No more children
                                }
                                int rightChild = leftChild + 1;
                                int maxChild = leftChild;
                                if (rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0) {
                                        maxChild = rightChild;
                                }

                                if(table[parent].compareTo(table[maxChild]) < 0) {
                                        swap (table, parent, maxChild);
                                        parent = maxChild;
                                } else {
                                        break;
                                }
                        }
                }
        }
        
        private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
                T temp = table[i];
                table[i] = table[j];
                table[j] = temp;
        }

        public static void main(String[] args) {
                Integer[] a1 = {3, 2, 19, 1, 20, 1, 10};         
                System.out.print("Array before sorting : ");
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
                System.out.println();
                HeapSort.sort(a1);
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
        }
}



