

import java.util.Arrays;


public class ArrayQueue<E> implements Queue<E> {
private static final int IC = 4;
private E[] elements;
private int size, first;

public ArrayQueue() {
	elements = (E[]) new Object[IC];
	first = 0;
	size = 0;
}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public E first() {
		if(isEmpty())
			return null;
		return elements[first];
		
	}

	@Override
	public void enqueue(E element) {
		if(size == elements.length) {
			this.changeCapacity(size*2);
		}
		elements[(first +size)%elements.length] = element;
		size ++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			return null;
		
		E etr = elements[first];
		
		first = (first +1)%elements.length;
		size --;
		
		return etr;
	}
	
	private void changeCapacity(int newCapacity) {
		
			E[] newArr = (E[]) new Object[newCapacity];
			for(int i =0; i<size;i++) {
				newArr[i] = elements[(first + i)%size];
				elements[i] = null;
			}
			elements = newArr;
			first = 0;
			
		
	}
	public String toString() {
		return Arrays.toString(elements);
	}


}
