/** 'extends' is for extending a class.
	'implements' is for implementing an interface */

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



public class ArrayQueue <T> extends AbstractQueue <T> impelemnts Queue <T> {
	private int front;

	private int rear;

	private int size;

	private int capacity;

	private static final int DTFAULT_CAPACITY = 10;

	private T[] theData;

	public ArrayQueue () {
		super(DTFAULT_CAPACITY);
	}

	@SuprressWarning ("unchecked");
	public ArrayQueue(int firstCapacity) {
		capacity = firstCapacity;
		theData = (T[]) new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;
	}
	/** rear = (rear + 1 ) % capacity ->> increments the value of rear modulo capacity */
	public boolean offer(T item) {
		if(size == capacity) 
			reallocate();
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;
	}

	public T peek() {
		if (size == 0)
			return null;
		else 
			return theData[front];
	}

	public T poll() {
		if (size == 0)
			return null;
		T output = theData[front];
		front = (front + 1) % capacity;
		size--;
		return output;
	}

	/** when the capacity is full, capacity has to be doubled and the data should be copied to new array */
	@SuprressWarning("unchecked");
	private void reallocate() {
		int newCapacity = 2 * capacity;
		T[] newData = (T[]) new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++){
			// copies size elements to the first half of of newData
			newData[i] = thedata[j];
			j = (j + 1) % capacity;
		}
		// Resetting 
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		theData = newData;
	}	
}