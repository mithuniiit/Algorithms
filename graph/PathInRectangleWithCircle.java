package graphs;

public class PathInRectangleWithCircle {

	static class graph{
		int m;
		int n;
		int k;
		int r;
		int[][] ordinate;
		int[][] matrix;
		
		graph(int m, int n, int k, int r){
			this.k = k;
			this.r = r;
			this.m = m;
			this.n = n;
			ordinate = new int[k][k];
			matrix = new int[m][n];
			
			for(int i=0; i<m ;i++) {
				for(int j=0; j<n; j++) {
					matrix[i][j]=1;
				}
			}
		}
		
		void updateMatrix() {
			//this iterates circles
			for(int p=0; p<k; p++) {
				//this iterates all the nodes in matrix
				for(int i=0; i<m;i++) {
					for(int j=0; j<n; j++) {
						double dist = Math.sqrt(Math.pow((ordinate[p][0] - i),2) + Math.pow((ordinate[p][1]- j),2));
						if(dist <= r) {
							matrix[i][j] = 0;
						}
					}
				}
			}
		}
		
		boolean isSafe(int x, int y) {
			if(x >=0 && x<m && y>=0 && y<n && matrix[x][y] == 1) {
				return true;
			}
			return false;
		}
		
		boolean dfs(int x, int y) {
			
			if(matrix[x][y] == 0)
				return false;
			
			if(x == m-1 && y == n-1)
				return true;
			
			if(isSafe(x+1,y))
				return dfs(x+1,y);
			
			if(isSafe(x,y+1))
				return dfs(x,y+1);
			
			if(isSafe(x-1,y))
				return dfs(x-1,y);
			
			if(isSafe(x,y-1))
				return dfs(x,y-1);
			
			return false;
 		}
	}
	
	public static void main(String []args) {
		graph g = new graph(5,5,2,1);
		g.ordinate[0][0] = 0;
		g.ordinate[0][1] = 2;
		g.ordinate[1][0] = 2;
		g.ordinate[1][1] = 2;
		g.updateMatrix();
		System.out.println(g.dfs(0,0));
	}
}
