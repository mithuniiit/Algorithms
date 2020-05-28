package arrays.rearrangement;

public class RearrangeArray {

	
	// 1  3  0  2
	// 0  1  2  3
	// -2 -4 -1 -3
	
	public static void rearrange(int[] a, int n, int start) {
		
		
		int value = start;
		int i = -(a[start]+1);
		
		while(a[i] < 0) {
			int next_i = a[i];
			a[i] = value;
			value = i;
			i = -(next_i+1);
		}
	}

	public static void main(String[] args) {
		//int a[] = { 1, 3, 0, 2 };
		int a[] = { 2, 0, 1, 4,5,3 };
		
		for(int i=0; i<a.length; i++) {
			a[i] = -(a[i] + 1);
		}
		
		for(int i=0; i<a.length;i++)
			if(a[i] < 0)
				rearrange(a,a.length,i);
		
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
