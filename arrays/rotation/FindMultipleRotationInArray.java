package arrays.rotation;

public class FindMultipleRotationInArray {

	static void leftRotate(int[] arr, int n,int k) {
		for(int i=k;i<n+k;i++) {
			System.out.println(arr[i%n]);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9}; 
        int n = arr.length; 
        
        int k = 2; 
        leftRotate(arr, n, k); 
        System.out.println(); 
          
        k = 3; 
        leftRotate(arr, n, k); 
        System.out.println(); 
          
        k = 4; 
        leftRotate(arr, n, k); 
        System.out.println();  
	}
}
