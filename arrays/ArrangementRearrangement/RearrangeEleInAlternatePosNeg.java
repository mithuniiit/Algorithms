package arrays.rearrangement;

public class RearrangeEleInAlternatePosNeg {

	public static void rearrange(int[] a, int n) {
		
		int i = -1;
		for(int j=0;j<n;j++) {
			if(a[j] < 0) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int neg = 0;
		int pos = i+1;
		while(pos<n && neg<pos && a[neg]<0) {
			int temp = a[pos];
			a[pos] = a[neg];
			a[neg] = temp;
			pos++;
			neg+=2;
		}
	}

	public static void main(String[] args) {
		int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		//int arr[] = {-1, -2, -3, -4, 1, 2, 3, 4, -5};
		int n = arr.length;
		rearrange(arr,n);

		System.out.println();
		for(int i=0; i<n; i++)
			System.out.print(" " + arr[i]);
	}
}
