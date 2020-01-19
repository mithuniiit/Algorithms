package dp;

public class FindLongestPath {

	// driver program 
    public static void main(String[] args) 
    { 
        int mat[][] = { { 1, 2, 9 }, 
                        { 5, 3, 8 }, 
                        { 4, 6, 7 } }; 
        int n = mat[0].length;
        System.out.println("Length of the longest path is " + findLongestOverAll(mat,n)); 
    }

    
    private static int findLongestOverAllUtil(int[][]mat, int n, int[][] dp,int i,int j) {
    	if(i<0 || i>=n || j<0 || j>=n) 
    		return 0;
    	
    	if(dp[i][j] != -1)
    		return dp[i][j];
    	
    	int u = Integer.MIN_VALUE;
    	int v = u;
    	int w = u;
    	int x = u;
    		
		if(j-1 >= 0 && mat[i][j-1]==1+mat[i][j])
			u = dp[i][j] = 1 + findLongestOverAllUtil(mat,n,dp,i,j-1);
		if(j+1 < n && mat[i][j+1]==1+mat[i][j])
			v = dp[i][j] = 1 + findLongestOverAllUtil(mat,n,dp,i,j+1);
		if(i-1 >= 0 && mat[i-1][j]==1+mat[i][j])
			w = dp[i][j] = 1 + findLongestOverAllUtil(mat,n,dp,i-1,j);
		if(i+1 < n && mat[i+1][j]==1+mat[i][j])
			x = dp[i][j] = 1 + findLongestOverAllUtil(mat,n,dp,i+1,j);
		
		return dp[i][j] = Math.max(u,Math.max(v,Math.max(w,Math.max(x,1))));
    }
	private static int findLongestOverAll(int[][] mat,int n) {
		int[][] dp = new int[n][n];
		int ret = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]=-1;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(dp[i][j]==-1)
					ret = findLongestOverAllUtil(mat,n,dp,i,j);
			}
		}
		
		return Math.max(1,ret);
	} 
}
