/** Hashtable that uses open addressing, represented as an array of Entry Objects */ 

public class HashOpen<K, V> implements HashMap<K, V> {
        private Entry<K, V> table; 
        private tatic final int INITIAL_CAPACITY = 101; 
