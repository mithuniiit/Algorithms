package dp;

public class Lis_DP {
	public static void main(String[] args) {
		int a[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = a.length; 
        System.out.println("Length of lis is " + findLis( a, n ) + "\n" ); 
	}

	private static int findLis(int[] a, int n) {
		int []lis = new int[n];
		
		for(int i=0;i<n;i++) {
			lis[i] = 1;
		}
		
		int max = 0;
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(a[i] > a[j] && lis[i] < i + lis[j]) {
					lis[i] = 1 + lis[j];
					max = Math.max(lis[i],max);
				}
			}
		}
		
		return max;
	}
}
