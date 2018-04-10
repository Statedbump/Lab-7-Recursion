;

public class FibbonacciMain {

	
	public static void main(String[] args) {
		Pair<Long> n = fib2(50);
		System.out.println(n.getFirst());
		System.out.println(fib(50));
		
	}
	
	public static long fib(long n) {
		
		if(n ==0 || n == 1) {
			return 1;
		}
		else {
			return fib(n-1)+fib(n-2);
		}
		
	}
	public static Pair<Long> fib2(long n) {
		if(n == 0 || n ==1) {
			return new Pair<Long>(1L,1L);
		}else {
			Pair<Long> p = fib2(n-1);
			
			return new Pair<Long>((p.getFirst()+p.getSecond()),p.getFirst());

					
		}
		
	}

}
