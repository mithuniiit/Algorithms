package arrays.rotation;

public class FindRotationCount {

	
	static int countRotations(int[] a,int left, int right) {
		if(left > right)
			return -1;
		
		if(left == right)
			return a[left];
		
		int mid = (left+right)/2;
		
		if(mid < right && a[mid] > a[mid+1]) {
			return mid+1;
		}
		
		if(mid > left && a[mid] < a[mid-1]) {
			return mid;
		}
		
		if(a[mid] < a[right]) {
			return countRotations(a,left, mid-1);
		}
		return countRotations(a,mid+1, right);
	}
	
	public static void main (String[] args)  
	{ 
		int arr[] = {15, 18, 2, 3, 6, 12}; 
		int n = arr.length; 

		System.out.println(countRotations(arr, 0, n-1)); 
	} 
}
