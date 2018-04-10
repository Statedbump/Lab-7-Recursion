
import java.util.ArrayList;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SortTester {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> ku = new ArrayQueue<>();
		Random rand = new Random();
		
		for(int i =0; i < 50 ;i++) {
		
			list.add(rand.nextInt(100));
			ku.enqueue(rand.nextInt(100));

		}
		
	
		System.out.println("Unsorted List : "+list.toString());
		System.out.println("Unsorted Queue: "+ku.toString());
	
		MergeSort.sortList(list);
		MergeSort.sort(ku);
	
		System.out.println("Sorted List :"+list.toString());
		System.out.println("Sorted Queue:"+ku.toString());

	}
	
}
