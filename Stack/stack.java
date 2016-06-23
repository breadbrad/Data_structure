public interface StackInt<E> {
	/** Pushes an item onto the top of the stack */
	E push(E obj);

	/** Returns the object at the top of the stack without removing it */
	E peek();

	/** Returns the obejct at the top of the stack and removes it */
	E pop();

	/** True if the stack is empty */
	boolean empty();
	
}