public class ArrayStack<E> implements StackADT<E> { 
	private E [] data;

	int topOfStack = 1;
	private static final int INITIAL_CAPACITY = 10;

	@SuppressWarnings("enchecked")
	public ArrayStack() {
		data = (E[]) new Object [INITIAL_CAPACITY];
	}

	@Override
	public E push(E obj) {
		if (topOfStack == data.length - 1) {
			reallocate();
		}
		topOfStack++;
		data[topOfStack] = obj;
		return obj;
	}

	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return data[topOfStack--];
	}
	}