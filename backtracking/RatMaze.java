package backtracking;

class RatMaze{

	static int N = 4;
	
	
	public static boolean isSafe(int [][]maze, int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N && maze[row][col] == 1)
			return true;
		return false;
	}
	
	public static boolean solveMazeUtil(int[][]maze, int[][] sol, int row, int col) {
		if(row == N-1 && col == N-1 && maze[row][col] == 1) {
			sol[row][col] = 1;
			return true;
		}
		
		if(isSafe(maze,row,col)) {
			sol[row][col] = 1;
			
			if(solveMazeUtil(maze,sol,row+1,col)) {
				return true;
			}
			
			if(solveMazeUtil(maze,sol,row,col+1)) {
				return true;
			}
			
			sol[row][col] = 0;
		}
		
		return false;
	}

	public static void print(int[][] sol) {
		for(int i=0; i<N; i++) {
			System.out.println();
			for(int j=0; j<N; j++) {
				System.out.print(sol[i][j]+" ");
			}
		}
	}
	
	public static void solveMaze(int[][]maze, int row, int col) {
		int [][]sol = new int[N][N];
		
		if(solveMazeUtil(maze,sol,row,col)) {
			print(sol);
		}
	}
	
	
	public static void main(String[] args){
		
		int maze[][] = { { 1, 0, 0, 0 }, 
						 { 1, 1, 0, 1 }, 
						 { 0, 1, 0, 0 }, 
						 { 1, 1, 1, 1 } };	
			
		solveMaze(maze,0,0);
	} 
}	