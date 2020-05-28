package arrays.rearrangement;

public class ArrangePosNegValuesAlternatively {

	public static void rearrange(int []a, int n) {
		int pos = 0;
		int neg = 1;
		int temp;
		
		while(true) {
			while(pos<n && a[pos] >= 0 ) {
				pos+=2;
			}
			
			while(neg<n && a[neg] <= 0) {
				neg += 2;
			}
			
			if(pos < n && neg < n) {
				temp = a[pos];
				a[pos] = a[neg];
				a[neg] = temp;
			}else
				break;
		}
	}
	
	
	public static void main(String args[]) { 
	    int arr[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10}; 
	    int n = arr.length; 
	  
	    rearrange(arr, n); 
	    for (int i = 0; i < n; i++) 
	    System.out.print(arr[i] + " "); 
	} 
}
