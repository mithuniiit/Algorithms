package arrays.OrderStat;

public class KMaxOverlappingSum {

	static void kmax(int a[], int k, int n) { 
		for(int i =0;i<k; i++) {
			int start = 0, end = 0, s = Integer.MIN_VALUE, maxSoFar = Integer.MIN_VALUE, maxEndingHere = Integer.MIN_VALUE;

			for(int j=0;j<n;j++) {
				
				maxEndingHere += a[j];
				
				if(maxSoFar < maxEndingHere) {
					maxSoFar = maxEndingHere;
					start = s;
					end = j;
				}
				
				if(maxEndingHere < 0) {
					maxEndingHere = 0;
					s = j+1;
				}
			}
			
			System.out.println("Max Overlapping SubArray"+i+" start ="+start+" end="+end);
			
			for(int j=start; j<=end; j++) {
				a[j] = Integer.MIN_VALUE;
			}
		}
	} 

	// Driver Program 
	public static void main(String[] args) 
	{ 
		// Test case 1 
		int arr1[] = {4, 1, 1, -1, -3, -5,  
				6, 2, -6, -2}; 
		int k1 = 3; 
		int n1 = arr1.length; 

		// Function calling 
		kmax(arr1, k1, n1); 
	} 
}
