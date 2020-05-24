package arrays.rearrangement;

public class RearrangePostiveAndNegativeWithOrdering {


	static void rotateRight(int []a, int n, int oop, int i) {
		int temp = a[i];
		
		for(int j=i;j>oop;j--) {
			a[j] = a[j-1];
		}
		
		a[oop] = temp;
	}
	
	static void rearrange(int[] a, int n) {
		int oop = -1;
		
		for(int i=0;i<n;i++) {
			if(oop >=0) {
				if( (a[i] >=0 && a[oop] <0) || (a[i] <0 && a[oop] >= 0) ){
					rotateRight(a,n,oop,i);
					if(i - oop > 2)
						oop = oop+2;
					else
						oop = -1;
				}
			}
			if((oop ==-1) && ((i%2 == 0 && a[i] < 0) || (i%2 == 1 && a[i] >=	0))){
				oop = i;
			}
		}
	}
	
	public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; 
        int n = arr.length; 
        rearrange(arr,n);
        for(int i=0;i<n;i++)
        	System.out.println(arr[i]);
	}
}
