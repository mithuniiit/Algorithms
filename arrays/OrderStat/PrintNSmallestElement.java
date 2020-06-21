package arrays.OrderStat;

public class PrintNSmallestElement {

	static void printSmall(int []a, int n, int k) {
		for(int i=k; i<n; i++) {

			//Find largest element in first k elements
			int max = Integer.MIN_VALUE;
			int index = 0;
			for(int j=0; j<k; j++) {
				if(a[j] > max) {
					max = a[j];
					index = j;
				}
			}

			if(a[i] < max) {
				for(int j = index; j<k-1; j++ ) {
					a[j] = a[j+1];
				}
				a[k-1] = a[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 }; 
		int n = 10; 
		int k = 5; 
		printSmall(arr, n, k);

		for(int i=0; i<k; i++)
			System.out.println(arr[i]);
	}
}
