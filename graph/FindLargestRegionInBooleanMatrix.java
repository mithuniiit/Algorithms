//https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/

package graphs;

public class FindLargestRegionInBooleanMatrix {
	
	static int count = 0;
	
	static boolean isSafe(int[][]M, boolean[][]V, int x, int y, int ROW, int COL) {
		if(x>=0 && x<ROW && y>=0 && y<COL && M[x][y]==1 && V[x][y]!=true)
			return true;
		
		return false;
	}
	
	static void dfs(int[][] M, boolean [][]V, int x, int y, int ROW, int COL) {
		if(!isSafe(M,V,x,y,ROW,COL))
			return;
		
		V[x][y] = true;
		
		count++;
		
		dfs(M,V,x-1,y-1,ROW,COL);
		dfs(M,V,x-1,y,ROW,COL);
		dfs(M,V,x-1,y+1,ROW,COL);
		dfs(M,V,x,y+1,ROW,COL);
		dfs(M,V,x+1,y+1,ROW,COL);
		dfs(M,V,x+1,y,ROW,COL);
		dfs(M,V,x+1,y-1,ROW,COL);
		dfs(M,V,x,y-1,ROW,COL);
	}
	
	
	static int largestRegion(int [][] M,int ROW, int COL) {
		boolean V[][] = new boolean[ROW][COL];
		int result = 0;
		for(int i=0 ;i<ROW; i++) {
			for(int j=0 ;j<COL; j++) {
				if(M[i][j] == 1 && V[i][j] != true) {
					count=0;
					dfs(M,V,i,j,ROW,COL);
					result = Math.max(result,count);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int M[][] = { {0, 0, 1, 1, 0},  
                {1, 0, 1, 1, 0},  
                {0, 1, 0, 0, 0},  
                {0, 0, 0, 0, 1}};  
		
		int ROW = 4,COL = 5;
		
		System.out.println(largestRegion(M,ROW,COL));
	}
}
