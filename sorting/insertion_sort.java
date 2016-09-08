import java.util.*;
class InsertionSort {

        public static <T extends Comparable<T>> void sort(T[] table) {
                for (int nextPos = 1; nextPos < table.length; nextPos++) {
                        insert(table, nextPos);
                }
        }

        private static <T extends Comparable<T>> void insert(T[] table, int nextPos) {
                T nextVal = table[nextPos]; // element to insert 
                while(nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
                        table[nextPos] = table[nextPos - 1]; // Shift down 
                        nextPos--; // check next smaller element 
                }
                // Insert nextVal at nextPos
                table[nextPos] = nextVal;
        }
        
        public static void main(String[] args) {
                Integer[] a1 = {3, 2, 19, 1, 20, 1, 10};         
                System.out.print("Array before sorting : ");
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
                System.out.println();
                InsertionSort.sort(a1);
                for(int nextItem : a1)
                        System.out.print(nextItem + " ");
        }
}


