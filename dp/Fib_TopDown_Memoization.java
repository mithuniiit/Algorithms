package dp;

public class Fib_TopDown_Memoization {

	
	public static void main(String[] args) {
		int n = 3;
		int[] fib = new int[n+1];
		System.out.println("Fib is "+calFib(fib,n));
	}

	private static int calFib(int[] fib,int n) {
		init(fib,n);
		return calFibUtil(fib,n);
	}

	private static int calFibUtil(int[] fib,int n) {
		if(fib[n] == -1) {
			if(n<=1) 
				fib[n]=n;
			else
				fib[n] = calFibUtil(fib, n-1) + calFibUtil(fib, n-2);
		}
		return fib[n];
	}
	
	private static void init(int[] fib,int n) {
		for(int i=0;i<n+1;i++) {
			fib[i]=-1;
		}
	}
}
