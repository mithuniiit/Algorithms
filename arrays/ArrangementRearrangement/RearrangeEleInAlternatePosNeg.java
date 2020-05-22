package arrays.rearrangement;

public class RearrangeEleInAlternatePosNeg {

	
	static int index = 0;
	static boolean flag = false;
	
	public static void swap(int []a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	
	static void check(int[] a,int i) {
		if(flag == true) {
			swap(a,index,i);
			flag = false;
		}
		else {
			index = i;
			flag = true;
		}
	}
	
	public static void rearrange(int []a, int n) {
		
		for(int i=0;i<n;i++) {
			if( (i%2 == 0 && a[i] < 0) || (i%2 == 1 && a[i] > 0)) {
				check(a,i);
			}
		}
	}
	
	
	public static void main(String[] args) {
		 int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9}; 
	     int n = arr.length;
	     rearrange(arr,n);
	     
	     System.out.println();
	     for(int i=0; i<n; i++)
	    	 System.out.print(" " + arr[i]);
	}
}
