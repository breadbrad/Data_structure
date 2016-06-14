import java.util.*;


class SingleLinkedList<E> {
            private Node<E> head = null;
            
            private int size;
            
            public void addFirst(E item) {
                head = new Node<E> (item, head);
                size++;
            }
                
            public void addAfter(Node<E> node, E item) {
                node.next = new Node<E> (item, node.next);
                size++;
            }
            
    public void add (int index, E item) {
        if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException(Integer.toString(index));
        }            
        if(index == 0) {
                    addFirst (item);
        } else {
            Node<E> node = getNode(index-1);
            addAfter(node, item);                
        }
    }
    private E removeAfter (Node<E> node) {
        Node<E> temp = node.next;
        if(temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    private E removeFirst() {
        Node<E> temp = head; 
        if (head != null) {
                head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
             return null;
        }
    }
    
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++) {
            node = node.next;
        }            
        return node; 
    }
    
    public String toString() {
        Node<E> nodeRef = head; 
        StringBuilder result = new StringBuilder();
        while (nodeRef != null) {
            result.append(nodeRef.data);
            if (nodeRef.next != null) {
                result.append(" ==> ");
            }
            nodeRef = nodeRef.next;
        }
        return result.toString();
    }
            
    public static void main(String[] args)
    { 
        Node<String> tom = new Node<String> ("Tom");
        Node<String> dick = new Node<String> ("Dick");
        Node<String> last = new Node<String> ("Last");
        tom.next = dick;
        dick.next = last;
        System.out.println(tom.next.next.data);
        
        SingleLinkedList<String> names = new SingleLinkedList<String>();
        names.addFirst("Sam");
        names.addFirst("Harry");
        names.addFirst("Dick");
        names.addFirst("Tom");
        
        System.out.println(names.getNode(1).data);
    }
    
    private static class Node<E> {
        private E data;
        
        private Node <E> next;
        
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;           
        }
    }
    
}