// Subset of the collection interface in package java.util 
public interface Collection<Anytype> extends Iterable<Anytype> 
{
	int size();
	boolean isEmpty();
	void clear();
	boolean contains( Anytype x );
	boolean add ( Anytype x );
	boolean remove( Anytype x );
	java.util.Iterator<Anytype> iterator();
}

// Using the enhanced for loop on an iterator type 
public static <Anytype> void print (Collection <Anytype> coll) 
{
	for ( Anytype item : coll ) 
		System.out.println( item );
}

// The iterator interface in java.util
public interface Iterator<Anytype> 
{
	boolean next;
	Anytype next(); // each call of next() gives the first, second items and so on.. 
	void remove(); // remove last item returned by the next() 
}
/* via the iterator method, each collection can create and return a collection */
public static <Anytype> void print(Collection<Anytype> coll)
{
	Iterator<Anytype> itr = coll.iterator();
	while(itr.hasNext())
	{
		Anytype item = itr.next();
		System.out.println(item);	
	}
}
