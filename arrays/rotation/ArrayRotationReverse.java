package arrays.rotation;

public class ArrayRotationReverse {
	
	static void rev(int[] arr, int start, int end) {
		for(int i=start,j=end; i<j; i++,j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	static void reverse(int[] arr, int n, int d) {
		rev(arr,0,d-1);
		rev(arr,d,n-1);
		rev(arr,0,n-1);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int d = 3;
		reverse(arr,arr.length,d);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
