
/** Queue -> used in a print queue 
	-----
	offer -> inserts an element at the rear of the queue
	-----
	remove / poll -> both remove & return the front element 
	if the queue is empty, 
	remove -> throws an exception 
	poll   -> returns null 
	-----
	peek / element -> both return the element at the front w/o removing it
	element -> throws an exception 
	*/

import java.util.*;

public class ListQueue <T> extends AbstractQueue <T> implements Queue <T> {
	// Reference to the front node 
	private Node <T> front; 
	// Reference to the rear node 
	private Node <T> rear; 
	// The size of a queue 
	private int size; 

 	public boolean offer (T item) {
 		// checking empty queue 
 		if(front == null) {
 			rear = new Node <T> (item);
 			front = rear; 
 		} else {
 			rear.next = new Node <T> (item);
 			rear = rear.next;
 		} 
 		size++;
 		return true;		
 	}

 	public T poll() {
 		T item = peek();
 		// if it is null, returns null
 		if(item == null) 
 			return null;
 		// change reference to next node 
 		front = front.next
 		size--;
 		return item;
 	}	

 	public T peek() {
 		if (size == 0)
 			return null;
 		else 
 			return front.data;
 	}


}