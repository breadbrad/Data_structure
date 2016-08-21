/**Hash tables store key-value pairs, this is an inner class Entry in each hash table
   implementation with data fields key and value */ 

private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
                this.key = key;
                this.value = value;
       }
        
        public K getKey() {
                return key;
        }

        public V getValue() {
                return value;
        }

        public V setValue(V val) {
                V oldVal = value;
                value = val;
                return oldVal;
        }

