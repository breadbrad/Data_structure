import java.util.*;

public class PriorityQueue<T> extends AbstractQueue<T> implements Queue<T> {
        private ArrayList <T> data;
        Comparator<T> comparator = null;

        public PriorityQueue() {
                data = new ArrayList<T>();
        }
        /** Creates a heap-based priority queue w/ the specified initial capacity 
                @param cap initial capacity 
                @param comp the comparator used to order for this priority queue 
                @throws IllegalArgumentException if the cap is less than 1 
        */
        public PriorityQueue(Comparator<T> comp) {
                if(cap < 1) {
                        throw new IllegalArgumentException();
                }
                data = new ArrayList<T>();
                comparator = comp;
        }

        /** Insert an item into the priority queue 
        */
        @Override 
        public boolean offer(T item) {
                data.add(item);
                int child = data.size() - 1;
                int parent = (child - 1) / 2;
                // Reheap 
                while(parent >= 0 && compare(data.get(parent), data.get(child)) > 0) {
                        swap(parent, child);
                        child = parent;
                        parent = (child - 1) / 2;
                }
                return true;
        }

        /** Remove an item from the priority queue 
                pre : is in heap order 
                post : Removed the smallest item, still in heap order 
                @return : The item with the smallest priority value or null if empty */
        @Override 
        public T poll() {
                if(isEmpty()){
                        return null;
                }

                T result = data.get(0); // Save the top of the heap 
                if (data.size() == 1) {
                        data.remove(0);
                        return result;
                }

                /* Remove the last item from the ArrayList and place it into the first position */
                data.set(0, data.remove(data.size - 1));
                // The parent starts at the top 
                int parent = 0;
                while(true) {
                        int leftChild = 2 * parent + 1;
                        if (leftChild >= data.size()) {
                                break;
                        }
                        int rightChild = leftChild + 1;
                        int minChild = leftChild; // Assume leftChild is smaller 
                        if (rightChild < data.size() && compare(data.get(leftChild), data.get(rightChild)) > 0) {
                                minChild = rightChild;
                        }
                        if (compare(data.get(parent), data.get(minChild)) > 0) {
                                swap(parent, minChild);
                                parent = minChild;
                        } else {
                                break;
                        }
                }
                return result;
        }

        private int compare(T left, T right) {
                if(comparator != null) {
                        return Comparator.comapre(left, right);
                } else {
                        return ((Comparable<T>) left).compareTo(right);
                }
        }
}
        
