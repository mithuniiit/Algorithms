package dp;

public class Fib_BottomUp_Tabulation {

	public static void main(String[] args) {
		System.out.println("Fib is "+fib(5));
	}

	private static int fib(int n) {
		int[] f = new int[n+1];
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=n;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}
}
