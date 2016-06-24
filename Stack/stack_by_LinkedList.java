public class LinkedList <E> implements StackADT<E> {
	@Override 
	public E push (E obj) {
		topOfStackRef = new Node <E> (obj, topOfStackRef);
		return obj;
	}

	@Override
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		else {
			E result = topOfStackRef;
			topOfStackRef = topOfStackRef.next
			return result;
		}
	}

	@Override
	public E peek () {
		if (empty()) {
			throw new EmptyStackException();
		}
	} 
	else {
		return topOfStackRef.data;
	}

	@Override
	public boolean empty() {
		return topOfStackRef == null;
	}
}