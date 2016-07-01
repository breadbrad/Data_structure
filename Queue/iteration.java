private class Iterate implements Iterator <AnyType> {
	private int index;

	private int count = 0;

	/** Constructor */
	public Iterate() {
		index = front;
	}

	@Override 
	public boolean hasNext() {
		return count < size; 
	}

	@Override
	public E next() {
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		AnyType result = theData[index];
		index = (index + 1) % capacity;
		count++;
		return result;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}