package arrays.rearrangement;

public class MoveAllZeroToEnd {

	static void swap(int[] a,int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void pushZerosToEnd(int []a, int n) {
		
		for(int i=0,j=n-1;i<j;) {
			
			if(a[i] != 0) {
				i++;
				continue;
			}
			
			if(a[j] == 0) {
				j--;
				continue;
			}
			
			swap(a,i,j);
		}
	}
	public static void main(String[] args) {
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
        int n = arr.length; 
        pushZerosToEnd(arr, n); 
        System.out.println("Array after pushing zeros to the back: "); 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
	}
}
