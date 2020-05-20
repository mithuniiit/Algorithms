package arrays.rotation;

public class PrintLeftRoation {

	static void leftRotate(int[] arr, int n, int k) {
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[(i+k)%n]);
		}
	}
	public static void main(String[] args) {
		 int arr[] = { 1, 3, 5, 7, 9 }; 
         int n = arr.length;  

         int k = 8; 
         leftRotate(arr, n, k); 
	}
}
