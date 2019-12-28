
public class indexOfFirstOne {
	public static void main(String[] args) {
		int a[] = {0,1,1,1,1,1,1,1,1};
		findFirstOne(a,0,a.length);
	}

	private static int findFirstOne(int[] a, int low, int high) {
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid]==1 && (mid==0 || a[mid-1]==0))
				return mid;
			else if( a[mid] == 0)
				low = mid+1;
			else 
				high = mid-1;
		}
		
		return -1;
	}
}
