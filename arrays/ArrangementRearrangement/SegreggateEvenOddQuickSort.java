package arrays.rearrangement;

public class SegreggateEvenOddQuickSort {
	static void arrayEvenAndOdd(int a[], int n) {
		int i = -1;
		int j = 0;
		while(j != n) {
			if(a[j]%2 == 0) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			j++;
		}
		
		for(i=0 ;i<n; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String args[]) 
    { 
        int arr[] = { 1, 3, 2, 4, 7,6, 9, 10 }; 
        int n = arr.length; 
        arrayEvenAndOdd(arr, n); 
    } 

}
