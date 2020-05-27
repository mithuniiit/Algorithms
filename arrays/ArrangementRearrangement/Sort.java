package arrays.rearrangement;

public class Sort {

	public static void insertion(int[]a, int n) {
			
		for(int i=1; i<n; i++) {
			int j = i-1;
			int key = a[i];
			while(j>=0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		
//		System.out.println();
//		for(int i=0; i<n;i++)
//			System.out.print(" "+ a[i]);
	}
	
	public static void swap(int[]a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int partition(int[]a, int l, int r) {
		int pivot = a[r];
		int i = l-1;
		
		for(int j=l; j<r; j++) {
			if(a[j] < pivot) {
				i++;
				swap(a, i , j);
			}
		}
		swap(a,i+1,r);
		return i+1;
	}
	
	public static void qsort(int[]a, int n, int l, int r) {
		if(l<r) {
			int p = partition(a,l,r);
			qsort(a,n,l,p-1);
			qsort(a,n,p+1,r);
		}
	}
	
	
	public static void quick(int []a, int n) {
		qsort(a,n,0,a.length-1);
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]);
	}
	
	
	public static void main(String[] args) {
		int []a = new int[]{3,  0,  4,  1,  2};
		int []b = a.clone();
		insertion(b,b.length);
		int []c = a.clone();
		quick(c,c.length);
	}
}
