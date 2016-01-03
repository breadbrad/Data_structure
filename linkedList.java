public class linkedList<Anytype> implements Iterable<Anytype> 
{
	private static class Node<Anytype>
	{
		public Node( Anytype d, Node<Anytype> p, Node<Anytype> n ) {
			data = d; prev = p; next = n;
		}	
	public Anytype data;
	public Node<Anytype> prev;
	public Node<Anytype> next;
	}
	public void clear(){}
	public int size(){}
	public boolean isEmpty() {}
	
	public boolean add(AnyType x ) {
	add( size(), x); return true;}
	
	public void add(int idx, AnyType x)
	{
		addBefore(getNode(idx, 0, size()), x);
	}
	
	private void addBefore()
}

