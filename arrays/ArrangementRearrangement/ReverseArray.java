package arrays.rearrangement;

public class ReverseArray {

	public static void reverse(int []a, int n) {
			int start = 0;
			int end = n-1;
			
			while(start < end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				start++;
				end--;
			}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		reverse(arr,arr.length);
		for(int i=0 ;i <arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
