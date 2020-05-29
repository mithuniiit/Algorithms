package arrays.rearrangement;

public class ReplaceEleWithMulOfPreAndNext {

	
	public static void modify(int[]a, int n) {
		if(n <= 1)
			return;
		
		int prev = a[0];
		a[0] = a[0] * a[1];
		
		for(int i=1;i<n-1;i++) {
			int curr = a[i];
			a[i] = prev * a[i+1];
			prev = curr;
		}
		
		a[n-1] = prev * a[n-1];
	}
	
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 5, 6}; 
        int n = arr.length; 
        modify(arr, n); 
        for (int i=0; i<n; i++) 
         System.out.print(arr[i]+" "); 
	}
}
