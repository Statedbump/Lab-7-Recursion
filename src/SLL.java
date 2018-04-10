import java.util.ArrayList;

public class SLL<E> {
	private static class Node<E> {
		private E element; 
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); } 
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }    
	}

	private Node<E> first = null; 
	private int size = 0;     
	public void addFirst(E e) { 
		first = new Node<>(e, first); 
		size++; 
	}

	// returns string formed by elements in this list, separated by spaces
	public String toString() { 
		String s = ""; 
		Node<E> current = first; 
		while (current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}  

	public void reverse(){

		if(size>1) {
			first = recReverse(null,first);
		}

	}
	public void reverse2(){

		if(size>1) {
			first = recReverse(first).getFirst();
		}

	}
	private Node<E> recReverse(Node<E> b, Node<E> c){
		if (c == null) return b;
		Node<E> a = c.getNext();
		c.setNext(b);
		return recReverse(c,a);
	}
	private Pair<Node<E>> recReverse(Node<E> f){
		if (f.getNext()== null) return new Pair<Node<E>>(f,null);
		Pair<Node<E>> p = new Pair<>(first,first.getNext());
		p.getSecond().setNext(first);;
		return recReverse(p.getSecond());
	}

	public ArrayList<E> lessThan(E e) { 
		ArrayList<E> result = new ArrayList<>();     // and empty ArrayList object
		if (size > 0) 
			recLessThan(first, e, result);   // passing only reference to result
		return result; 
	}


	private void recLessThan(Node<E> fr, E e, ArrayList<E> result) { 
		if (fr != null) { 
			if (((Comparable<E>) fr.getElement()).compareTo(e) < 0) {
				result.add(e); }
			recLessThan(fr.getNext(), e, result);  // passing reference to result
		}
	} 

	private void recCIP(Node<E> first, ArrayList<Pair<E>> result) {
		// TODO Auto-generated method stub
		if(first != null && first.getNext() != null) {
			if(((Comparable<E>) first.getElement()).compareTo(first.getNext().getElement()) < 0) {
				Pair<E> thePair = new Pair<E>(first.getElement(), first.getNext().getElement());
				result.add(thePair);
			}
			recCIP(first.getNext(), result);
		}
	}
	

public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
   ArrayList<Pair<E>> result = new ArrayList<>();     // and empty ArrayList object
   if (size > 0) 
      recCIP(first, result); 
   return result; 
}




}
