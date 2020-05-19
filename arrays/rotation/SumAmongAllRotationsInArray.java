package arrays.rotation;

public class SumAmongAllRotationsInArray {


	static int maxSum(int[] a, int n) {
		
		int cs = 0, cv =0, max=0;
		
		for(int i=0;i<n;i++) {
			cs += a[i] * i;
			cv += i;
		}
		
		
		int runningSum = 0;
		max = cs;
		//As we left shift decrement all execpet a[i-1]
		//increment that value by n*a[i-1]
		for(int i=1;i<n;i++) {
			runningSum = runningSum - (cv-a[i-1]) + (a[i-1] * (n-1));
			max = Math.max(max,runningSum);
		}
		return max;
	}
	
	public static void main(String[] args) 
	{ 
		int arr[] = {8, 3, 1, 2}; 
		int n = arr.length; 
		System.out.println(maxSum(arr, n)); 
	} 

}
