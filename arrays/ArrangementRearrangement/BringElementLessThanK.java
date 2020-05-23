package arrays.rearrangement;

public class BringElementLessThanK {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void minSwap(int []a, int n, int k) {
		for(int i=0,j=n-1;i<k;) {
			if(a[i] <= k) {
				i++;
				continue;
			}

			if(a[j] > k) {
				j--;
				continue;
			}
			swap(a, i, j);
		}
	}

	public static void main(String[] args) {
		int arr[] = {2, 1, 5, 6, 3}; 
		int n = arr.length; 
		int k = 3; 

		minSwap(arr,n,k);
		
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.print(arr[i]);
	}
}
