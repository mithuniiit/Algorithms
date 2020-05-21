package arrays.rearrangement;

public class RearragneArrayWithSameIndex {

	static void rearrange(int []a,int n) {

		for(int i=0;i<n;i++) {
			while(a[i] != i && a[i] != -1) {
				int x = a[i];
				int y = a[x];
				a[x] = x;
				a[i] = y;
			}
		}
	}

	public static void main(String[] args) {
		//int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		int[] arr = {1,2,3,4,5,-1};
		rearrange(arr,arr.length);
		for(int i=0 ;i <arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
