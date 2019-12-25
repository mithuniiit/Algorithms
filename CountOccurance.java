
public class CountOccurance {
	public static void main(String[] args) {
		int a[]= { 1,1,2,3,4,5,5,5,5,5,5,5,5};
		System.out.println("Number of time element occured is "+countOccurance(a,5));
	}

	private static int countOccurance(int[] a, int x) {
		int i,j,n=a.length;
		
		i = first(a,0,n-1,x);
		System.out.println("i = "+i);
		if(i==-1)
			return 0;
		j = last(a,i,n-1,x);
		System.out.println("j = "+j);
		return (j-i+1);
	}

	private static int last(int[] a, int low, int high, int x) {
		int mid;
		if(low <= high) {
			mid = (low+high)/2;
			if(a[mid] == x && ( mid == a.length - 1 || a[mid]<a[mid+1]))
				return mid;
			else if(x < a[mid])
				return last(a , low, mid-1,x);
			else
				return last(a,mid+1,high,x);
		}
		return -1;
	}

	private static int first(int[] a, int low, int high, int x) {
		int mid;
		if(low <= high) {
			mid = (low+high)/2;
			if(a[mid] == x && ( mid == 0 || a[mid-1]<a[mid]))
				return mid;
			else if(x > a[mid])
				return first(a , mid+1, high,x);
			else
				return first(a,low,mid-1,x);
		}
		return -1;
	}
}
