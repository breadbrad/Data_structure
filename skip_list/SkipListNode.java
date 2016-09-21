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

