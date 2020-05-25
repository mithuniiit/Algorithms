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
	
	
	public static void findMin(int[]a, int n, int k) {
		
		int count = 0;
		
		for(int i=0; i<n;i++) {
			if(a[i] <= k)
				count++;
		}
		
		int bad = 0;
		for(int i=0;i<count;i++) {
			if(a[i] > k)
				bad++;
		}
		
		int ans = bad;
		
		for(int i=0,j=count;j<n;j++,i++) {
			if(a[i]>k)
				bad--;
			
			if(a[j]>k)
				bad++;
			
			ans = Math.min(ans,bad);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int arr[] = {2, 1, 5, 6, 3}; 
		int n = arr.length; 
		int k = 3; 

		findMin(arr,n,k);
		//minSwap(arr,n,k);
		
//		System.out.println();
//		for(int i=0;i<n;i++)
//			System.out.print(arr[i]);
	}
}
