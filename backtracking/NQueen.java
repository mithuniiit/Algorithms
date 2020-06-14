package backtracking;
/* Java program to solve N Queen 
Problem using backtracking */

class NQueen 
{
	static int N = 4;
	
	
	public static boolean isSafe(int[][] board, int row, int col) {
		int i,j;
		
		//check row
		for(i=0; i<col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		//check col
//		for(i=0; i<row; i++) {
//			if(board[i][row] == 1)
//				return false;
//		}
		
		//check diagonal upper half
		for(i=row,j=col; i>=0 && j>=0 ; i--,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		for(i=row,j=col; i<N && j>=0 ; i++,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}

	public static boolean solveNQUtil(int [][]board,int col) {
		if(col == N) {
			print(board);
			return true;
		}
			
		boolean res = false;
		for(int i=0; i<N;i++) {
			if(isSafe(board,i,col)) {
				board[i][col] = 1;
				res = solveNQUtil(board,col+1) || res;
				board[i][col] = 0;
			}
		}
		
		return res;
	}

	public static void print(int [][]board) {
		System.out.println();
		for(int i=0;i<N;i++) {
			System.out.println();
			for(int j=0;j<N;j++) {
				System.out.print(" "+board[i][j]);
			}
		}
	}

	public static void solveNQ() {
		int[][] board = new int[N][N];
		if(!solveNQUtil(board,0)) {
			System.out.println("No Sol");
			return;
		}
	}

	public static void main(String[] args) 
	{ 
		solveNQ(); 
	} 
}