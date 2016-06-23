public interface Comparable<E> {
	/** Method to compare this obejct to the argument object 
		@param obj The argument object 
		@return Returns a negative integer if this object < obj;
				zero if this object equals obj;
				a postivie integer if this object > obj
	*/
	int compareTo(E obj);
}

// a class that implements the Comparable interface must provide a compareTo method that retuns an int value 

/** A class to represent an ordered list. The data is stored in a linked list data field 
*/
public class OrderedList<E extends Comparable <E>> implements Iterable <E> {
		/** A linked list to contain the data */
		private LinkedList <E> theList = new LinkedList <E> ();
}

public void add (E obj){
		ListIterator <E> iter = theList.listIterator();
		// Find the insertion position and insert
		while(iter.hasNext()) {
			if(obj.compareTo(iter.next()) < 0) {
				// Iterator has stepped over the first element 
				// that is greater than the element to be inserted 
				// Move the iterator back one 
				iter.previous();
				// Inset the element 
				iter.add(obj);
				// Exit the loop and return 
			}
		}
}