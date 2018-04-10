

public class ReverseTester {
	
	public static void main(String[] args) {
		SLL<Integer> list = new SLL<>();
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());
	}

}
