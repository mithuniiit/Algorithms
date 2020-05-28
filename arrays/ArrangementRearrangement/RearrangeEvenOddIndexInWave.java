package arrays.rearrangement;

public class RearrangeEvenOddIndexInWave {

	static void swap(int []a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void printArray(int []a, int n) {
		for(int i=0;i<n-1;i++) {
			if(i%2 == 0 && a[i] > a[i+1])
				swap(a,i,i+1);
			if(i%2 != 0 && a[i] < a[i+1])
				swap(a,i,i+1);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = { 6, 4, 2, 1, 8, 3 }; 
        int n = arr.length; 
        
        printArray(arr,n);
        
        System.out.println();
        for(int i=0; i<n; i++)
        	System.out.print(arr[i]);
	}
}
