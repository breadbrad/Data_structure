/** Hashtable that uses open addressing, represented as an array of Entry Objects */ 

public class HashOpen<K, V> implements HashMap<K, V> {
        private Entry<K, V> table; 
        private static final int INITIAL_CAPACITY = 101; 
        private double LOAD_THRESHOULD = 0.75;
        private int numKeys;
        private int numDeletes;
        private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

        public HashOpen() {
                table = new Entry<K, V>();
        }

        private int find(Object key) {
                int index = key.hashCode() % table.length;
                if (index < 0) 
                        index += table.legnth; // Make it positive 
                
                while((table[index] != null) && (!key.equals(table[index].key))) {
                        index++;
                        if (index >= table.length) 
                                index = 0; // Wrap around 
                }
                return index;
        }

        @Override 
        public V get(Obejct key) {
                int index = find(key);
                // if the search is successful, returns the value 
                if (table[index] != null) 
                        return table[index].value;
                else 
                        return null;
        }

        @Override 
        public V put(K key, V value) {
                int index = find(key);

                if(table[index] == null) {
                        table[index] = new Entry<K, V> (key, value);
                        numKeys++;
                        // check if rehash is needed 
                        double loadFactor = (double) (numKeys + numDeletes) / table.legnth;
                        if (loadFactor > LOAD_THRESHOULD) 
                                rehash();
                        return null;
                }
                
                // assert: table element that contains the key was found 
                // Replace value for this key 
                V oldVal = table[index].index;
                table[index].value = value;
                return oldVal;
        }

// Rehashing - 1. Allocate a new hash table (double the size) and has a odd lenght 
// 2. Reset the number of keys and number of deletions to 0
// 3. Reinsert each table entry that has not been delted in the new hash table 

private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[2 * oldTable.length + 1]; 
        numKeys = 0;
        numDeletes = 0; 
        for (int i = 0; i < oldTable.length; i++) {
                if((oldTale[i] != null) && (oldTable[i] != DELETED)) {
                          put(oldTable[i].key, oldTable[i].value);
                }
        }
}


        
       




