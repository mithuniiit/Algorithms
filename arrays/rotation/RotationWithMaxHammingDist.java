package arrays.rotation;

public class RotationWithMaxHammingDist {

	
	public static void maxHamming(int[] a,int n) {
		int[] b = new int[2*n];
		
		for(int i=0;i<n;i++) {
			b[i] = b[i+n] = a[i];
		}
		
		int max = 0;
		for(int i=1; i<n; i++) {
			int count = 0;
			for(int j=0,k=j+1; j<n; j++,k++) {
				if(a[j] != b[k]) {
					count++;
				}
			}
			max = Math.max(count,max);
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
	    int arr[] = {1, 1, 1, 8};  
	    int n = arr.length; 
	    maxHamming(arr, n);   
	}
}
