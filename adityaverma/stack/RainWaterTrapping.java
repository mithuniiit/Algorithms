package verma.stack;

public class RainWaterTrapping {

	public RainWaterTrapping() {
		// TODO Auto-generated constructor stub
	}
	
	public static void tapWater(int[]a) {
		
		if(a == null || a.length == 0)
			System.out.println("No Solution");
		
		int n = a.length;
		
		int[] lmax = new int[n];
		lmax[0] = a[0];
		
		//Find max towards left
		for(int i=1;i<n;i++) {
			lmax[i] = Math.max(a[i],lmax[i-1]);
		}
			
			
		int[] rmax = new int[n];
		rmax[n-1] = a[n-1];
		for(int i=n-2;i>=0;i--) {
			rmax[i] = Math.max(rmax[i+1],a[i]);
		}
		
		int[]capacity = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			int min = Math.min(lmax[i],rmax[i]);
			capacity[i] =  min > a[i] ? min-a[i] : 0; 
			sum += capacity[i];
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		//int[]a = {3,0,0,2,0,4};
		int[]a = {1,3,1,3,1};
		tapWater(a);
	}

}
