// HashSetOpen -> as an adapter class 
public class HashSetOpen<K> {
        private HashMap<K, V> setMap = new HashOpen<K, V>();
        /**@return true if the key is found in setMap*/ 
        public boolean contains(Object key) {
                // HashOpen.get returns null if the key is not found 
                return (setMap.get(key) != null);
        }
        /** post: Adds a new Entry object 
            @return true if the key is not a duplicate */
        public boolean add(K key) {
                reutrn (setMap.put(key, key) == null);
        }
        
        public boolean remove(Object key) {
                return (setMap.remove() != null);
        }
}
        
