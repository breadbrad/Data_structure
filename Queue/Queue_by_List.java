
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

public class ListQueue <E> extends AbstractQueue <E> implements Queue <E> {
	// Reference to the front node 
	private Node <E> front; 
	// Reference to the rear node 
	private Node <E> rear; 
	// The size of a queue 
	private int size; 

 	public boolean offer (E item) {
 		// checking empty queue 
 		if(front == null) {
 			rear = new Node <E> (item);
 			front = rear; 
 		} else {
 			rear.next = new Node <E> (item);
 			rear = rear.next;
 		} 
 		size++;
 		return true;		
 	}

 	public E poll() {
 		E item = peek();
 		// if it is null, returns null
 		if(item == null) 
 			return null;
 		// change reference to next node 
 		front = front.next
 		size--;
 		return item;
 	}	

 	public E peek() {
 		if (size == 0)
 			return null;
 		else 
 			return front.data;
 	}


}