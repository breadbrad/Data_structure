import java.util.*;

public class HashChain<K, V> implements HashMap<K, V> {
        private LinkedList<Entry<K, V>>[] table;
        private int numKeys;
        private static final int CAPACITY = 101;
        private static final double LOAD_THRESOULD = 3.0;

        public HashChain() {
                table = new LinkedList[CAPACITY];
        }
        @Override 
        public V get(Object key) {
                int index = key.hashCode() % table.length; 
                if (index < 0) 
                        index += table.length;
                if (table[index] == null) 
                        return null;
        
        for(entry<k, v> nextItem : table[index]) {
                if(nextItem.key.equals(key))
                        return nextItem.value;
        }
        // assert: key is not in the table 
        return null;
        }
         
        @Override 
        public V put(K key, V value) {
                int index = key.hashCode() % table.length;
                if (index < 0) 
                        index += table.length;
                if (table[index] == null) {
                       table[index] = new LinkedList<Entry<K, V>>();
                }
                for(entry<k, v> nextItem : table[index]) {
                        // if the search is successful, replace the old value 
                        if (nextItem.key.equals(key)) {
                                V oldVal = nextItem.value;
                                nextItem.setValue(value);
                                return oldVal;
                        }
                }

                // assert: key is not in the table, add new item 
                table[index].addFirst(new Entry<K, V>(key, value));
                numKeys++;
                if (numKeys > (LOAD_THRESOULD * table.length)) 
                        rehash();
                return null;
        }


                

                
