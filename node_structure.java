private static class Node <T> {
	/** Reference to the data */
	private T data;
	
	/** Reference to the next node */
	private Node <T> next;

	/** Creates a new node with a null next field 
		@param item : the data stored */
	private Node (T item) {
		data = item;
		next = null;
	}

	/** Creates a new node that references another node 
		@param item : the data stored 
		@param ref : the node referenced by new node */ 
	private Node <T> (T item, Node <T> ref) {
		data = item;
		next = ref;
	}
}