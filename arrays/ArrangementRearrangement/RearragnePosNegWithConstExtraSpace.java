package arrays.rearrangement;

public class RearragnePosNegWithConstExtraSpace {
	
	public static void  insertion(int[]a, int n) {
		for(int i=1;i<n;i++) {
			int key = a[i];
			
			if(key > 0 )
				continue;
			
			int j = i-1;
			while(j>=0 && a[j] >= 0) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}
	
	
	public static void merge(int[]a, int low, int mid, int high) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0;i<n1;i++)
			L[i] = a[low+i];
		
		for(int i=0;i<n2;i++)
			R[i] = a[mid+1+i];
		
		int i=0, j=0 , k=low;

		while(i<n1 && L[i] <0) {
			a[k++] = L[i++];
		}
		
		while(j<n2 && R[j]<0) {
			a[k++] = R[j++];
		}
		
		while(i<n1)
			a[k++] = L[i++];
		
		while(j<n2)
			a[k++] = R[j++];
	}
	
	public static void mergesort(int[]a,int low, int high) {
		if(low < high) {
			int mid = (low + high)/2;
			mergesort(a,low,mid);
			mergesort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public static void main(String[] args) {
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		//int arr[] = { -12, 11, -13, -5};
        int n = arr.length;
//        insertion(arr,n);
//        System.out.println();
//        for(int i=0;i<n;i++) {
//        	System.out.print(" "+arr[i]);
//        }
        
        //=======MERGE SORT=====
        mergesort(arr,0,n-1);
        System.out.println();
        for(int i=0;i<n;i++) {
        	System.out.print(" "+arr[i]);
        }
	}
}
