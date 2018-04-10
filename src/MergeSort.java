import java.util.ArrayList;

public class MergeSort<E> {
	
	@SuppressWarnings("unchecked")
	// Code Given by Proffesor
	public static <E> void sort(Queue<E> q) {    // sorts the elements in q in non-decreasing order
	   if (q.size() > 1) {     // if size is <= 1, then nothing needs to be done
	      Queue<E> q1, q2; 
	     
	      // Initialize q1 and q2 to empty instances of  ArrayQueue as implemented in previous lab.
	      q1 = new ArrayQueue<>(); 
	      q2 = new ArrayQueue<>(); 
	      
	      // split the elements of q in two halves (or close to), first half into q1 and second half into q2
	      int n = q.size(); 
	      for (int i=0; i<n/2; i++) {
	          q1.enqueue(q.dequeue()); }
	      while (!q.isEmpty()) {
	          q2.enqueue(q.dequeue()); }
	      
	      sort(q1);    // recursively sort q1
	      sort(q2);    // recursively sort q2
	      
	      // What is left to do now is the merging operation. Given that q1 and q2 are each sorted, 
	      // efficiently combine is elements back into q so that they are placed in order from first to last. 
	      // This process efficiently exploits the property that both, q1 and q2, are sorted.
	      while (!q1.isEmpty() && !q2.isEmpty()) {
	          if (((Comparable<E>) q1.first()).compareTo(q2.first()) <=0)
	             q.enqueue(q1.dequeue()); 
	          else 
	             q.enqueue(q2.dequeue()); 
	      }
	      // At this moment, one of the two queues, either q1 or q2, is empty.
	      Queue<E> r = (!q1.isEmpty() ? q1 : q2);  // find which, q1 or q2, is not empty yet
	      while (!r.isEmpty())
	          q.enqueue(r.dequeue()); 
	     } 
	}
	
	@SuppressWarnings("unchecked")
	public static <E> void sortList(ArrayList<E> list) {    
		   if (list.size() > 1) {  
		      Queue<E> q1, q2; 
		     
		      q1 = new ArrayQueue<>(); 
		      q2 = new ArrayQueue<>(); 
		      
		     
		      int n = list.size(); 
		      for (int i=0; i<n/2; i++) 
		          q1.enqueue(list.get(i)); 
		      for (int j=n/2; j<n; j++)
		    	  q2.enqueue(list.get(j));
		      
		      list.clear();
		      sort(q1);    // recursively sort q1
		      sort(q2);    // recursively sort q2
		      
		      while (!q1.isEmpty() && !q2.isEmpty())
		          if (((Comparable<E>) q1.first()).compareTo(q2.first()) <= 0)
		             list.add(q1.dequeue()); 
		          else 
		             list.add(q2.dequeue()); 
		      
		      
		      Queue<E> r = (!q1.isEmpty() ? q1 : q2); 
		      while (!r.isEmpty())
		          list.add(r.dequeue()); 
		     } 
		}

}