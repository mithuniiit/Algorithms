package verma.slidingwindow;

public class MaxOfAllSubarrayOfSizeK {

	public MaxOfAllSubarrayOfSizeK() {
		// TODO Auto-generated constructor stub
	}
	
	public static void findMax(int[]a, int k) {
		int n = a.length;
		int max = Integer.MIN_VALUE;

		for(int i=0,j=0;i<n;i++) {
			max = Math.max(a[i],max);
			if(i-j+1 == k) {
				System.out.println(max);
				if(a[j] == max)
					max = Integer.MIN_VALUE;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int K=3;
		findMax(a,3);
	}
}
