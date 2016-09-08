class ShellSort {
        public static <T extends Comparable<T>> void sort(T[] table) {
                int gap = table.length / 2;
                while (gap > 0) {
                        for (int nextPos = gap; nextPos < table.length; nextPos++) { 
                                //insert element at nextPos in its subarray
                                insert(table, nextPos, gap);
                        }
                        if(gap == 2){
                                gap = 1;
                        }
                        else {
                                gap = (int) (gap / 2.2);
                        }
               }
        }

        
        public static <T extends Comparable<T>> void insert(T[] table, int nextPos, int gap) {
                T nextVal = table[nextPos]; // element to insert
                while((nextPos > gap - 1)  && (nextVal.compareTo(table[nextPos - gap]) < 0)) {
                        table[nextPos] = table[nextPos - gap]; // shift down
                        nextPos -= gap; // Check next position in subarray
                }
                table[nextPos] = nextVal; // insert nextVal
        }

        public static void main(String[] args) {
                Integer[] a1 = {3, 2, 19, 1, 20, 1, 10};         
                System.out.print("Array before sorting : ");
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
                System.out.println();
                ShellSort.sort(a1);
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
        }
}
