class SkipList {
        /** static class to contain the data and the links */
        static class SkipListNode<T> {
                SkipListNode<T>[] links;
                T data;

                /** Create a node of level m */
                SkipListNode(int m, E data) {
                        links = (SkipListNode<T>[]) new SkipListNode[m]; // create links
                        this.data = data;
                }
        }

        @SupressWarnings("unchecked")
        /** Search for an item in the list
            @param item The item being sought 
            @return A SkipListNode array which referecnes the predecessors of 
                        the target at each level.
        */
        private SkipListNode<T> search(T target) {
                SkipListNode<T> [] pred = (SkipListNode<T> []) new SkipListNode[maxLevel];
                SkipListNode<T> current = head;
                for (int i = current.links.lenght-1; i>=0; i--) {
                        while (current.links[i] != null
                                && current.links[i].data.compareTo(target) < 0) {
                                current = current.links[i];
                        }
                        pred[i] = current;
                }
                return pred;
        }

        /** Find an object in the skip-list
            @param target The item being sought
            @return A reference to the object in the skip-list that matches 
                        the target. If not found, null is returned.
        */
        public T find(T target) {
                SkipListNode<T> [] pred = search(target);
                if (pred[0].links[0] != null &&
                        pred[0].links[0].data.compareTo(target) == 0) {
                                return pred[0].links[0].data;
                        } else {
                                return null;
                        }
                }
}
