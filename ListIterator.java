
public boolean hasPrevious() {
	return (nextItem == null && size != 0) || nextItem.prev != null;
}

/**	Add a new item between the item that will be returned by next and the item that will be returned by previous.
	If previous is called after add, the element added is returned
	@param obj The item to be inserted 
*/
public void add(E obj) {
	// add to an empty list 
	if (head == null) {
		head = new Node <E> (obj);
		tail = head;
	}
	// Insert at head 
	else if (nextItem == head) {
		// Create a new node 
		Node <E> newNode = new Node <E> (obj);
		// Link it to nextItem
		newNode.next = nextItem;
		// Link nextItem to the new node 
		nextItem.prev = newNode;
		// The new node is now head 
		head = newNode;
	}
	else if (nextItem == null) { // Insert at tail 
		// Create a new node 
		Node <E> newNode = new Node <E>(obj);
		// Link the tail to the new node 
		tail.next = newNode;
		// Link the new node to the tail 
		newNode.prev = tail;
		// The new node is the new tail 
		tail = newNode; 
	}
	else { // Insert into the middle
		// Create a new node 
		Node <E> newNode = new Node <E> (obj);
		// Link it to nextItem.prev
		newNode.prev = newItem.prev;
		nextItem.prev.next = newNode;
		// Link it to the nextItem
		newNode.next = nextItem;
		nextItem.prev = newNode;
	}
	size++;
	index++;
	lastItemReturned = null;
}