import java.util.*;

public class ListStack <E> implements StackInt <E> {
	private List <E> theData;

	public ListStack() {
		theData = new ArrayList <E> ();
	}

	@Override 
	public E push(E obj) {
		theData.add(obj);
		return obj;
	}

	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return theData.get(theData.size() - 1);
	}

	@Override
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return theData.remove(theData.size() - 1);
	}

	@Override
	public boolean empty() {
		return theData.size() == 0;
	}
}



