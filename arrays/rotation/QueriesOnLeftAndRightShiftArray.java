package arrays.rotation;

public class QueriesOnLeftAndRightShiftArray {
	
	
	static void findSum(int[]a,int n, int l, int r) {
		int []pre = new int[n];
		
		pre[0] = 0;
		
		for(int i=1;i<=n;i++) {
			pre[i] = pre[i-1] + a[i-1];
		}
		
		l = l%n;
		r = r%n;
		
		int sum = 0;
		if(l<r) {
			sum = pre[r+1] - pre[l];
		}else {
			sum = pre[n] - (pre[r+1] - pre[l]);
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
	    int a[] = { 1, 2, 3, 4, 5 }; 
	    int n = a.length;
	    findSum(a,a.length,2,4);
	}

}
