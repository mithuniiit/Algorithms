package arrays.rotation;

public class ReversalAlgoForRightRotation {

	
	
	static void reverseArray(int[]arr, int src, int dest) {
		while(src<dest) {
			int temp = arr[src];
			arr[src] = arr[dest];
			arr[dest] = temp;
			src++;
			dest--;
		}
	}
	
	static void rightRotate(int[]arr, int k, int n) {
		
		reverseArray(arr,0,n-1);
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}


	public static void main (String[] args)  
	{ 
		int arr[] = {1, 2, 3, 4, 5,  
				6, 7, 8, 9, 10}; 

		int n = arr.length; 
		int k = 3; 

		rightRotate(arr, k, n); 
	} 

}
