
public class countPaths {
	
	public static void main(String[] args) {
		System.out.println(countPathRecursive(2,2));
		System.out.println(countPathDP(2,2));
	}

	private static int countPathDP(int m, int n) {
		int arr[][] = new int[m][n];
		
		for(int i=0;i<m;i++) {
			arr[i][0]=1;
		}
		
		for(int i=0;i<n;i++) {
			arr[0][i]=1;
		}
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++)
				arr[i][j]= arr[i-1][j]+arr[i][j-1];
		}
		
		return arr[m-1][n-1];
	}

	private static int countPathRecursive(int i, int j) {
		if(i==1 || j==1)
			return 1;
		
		return countPathRecursive(i-1,j) + countPathRecursive(i,i-1); 
	}
	
}
