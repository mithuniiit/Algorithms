package backtracking;

public class Sudoku {

	public static boolean isSafe(int[][] board,int row, int col, int num, int n) {
		//Check Row
		for(int i=0;i<n;i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		//Check col
		for(int i=0;i<n;i++) {
			if(board[i][col] == num) {
				return false;
			}
		}
		
		//Check within the matrix
		int sqrt = (int) Math.sqrt(n);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;
		
		for(int r = boxRowStart; r< boxRowStart+sqrt; r++) {
			for(int c = boxColStart; c< boxColStart+sqrt; c++) {
				if(board[r][c] == num)
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean solveSudoku(int [][]board, int n) {
		
		boolean found = true;
		int i=-1;
		int j=-1;
		
		//Find free slot in the board
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(board[i][j] == 0) {
					found = false;
					break;
				}
			}
			if(!found)
				break;
		}
		
		if(found)
			return true;
		
		//Now we have found a free slot. let us find the right place.
		for(int num=1; num<=n; num++) {
			if(isSafe(board,i,j,num,n)) {
				board[i][j] = num;
				if(solveSudoku(board,n))
					return true;
				else
					board[i][j] = 0;
			}
		}

		return false;
	}
	
	
	public static void print(int [][]board, int N) {
		for(int i=0;i<N;i++) {
			System.out.println();
			for(int j=0;j<N;j++) {
				System.out.print(" "+board[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { 
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
		}; 
		int N = board.length; 

		if (solveSudoku(board, N)) { 
			// print solution 
			print(board, N); 
		} 
		else { 
			System.out.println("No solution"); 
		} 
	} 
}
