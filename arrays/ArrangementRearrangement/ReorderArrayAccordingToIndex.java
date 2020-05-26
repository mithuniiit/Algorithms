package arrays.rearrangement;

public class ReorderArrayAccordingToIndex {

	 static int arr[] = new int[]{50, 40, 70, 60, 90}; 
	 static int index[] = new int[]{3,  0,  4,  1,  2}; 
	    
	 
	public static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	public static void reorder() {

		for(int i=0;i<arr.length;i++) {
			while(index[i] != i) {
				swap(i,index[i],arr);
				swap(i, index[i], index);
			}
		}
	}
	 
	    
	public static void main(String[] args) {
		reorder();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
