class Sudoku{
	
	public static boolean isSafe(int[][] board,int row,int col,int num){
		for(int d=0;d<num;d++){
		  if (board[row][d] == num)  
            return false; 
        }
		
		for (int r = 0; r < board.length; r++) 
		{
			if (board[r][col] == num) 
				return false;
		}
		
		int sqrt = (int) Math.sqrt(board.length); 
		int boxRowStart = row - row % sqrt; 
		int boxColStart = col - col % sqrt; 
		for (int r = boxRowStart; r < boxRowStart + sqrt; r++)  {
			for (int d = boxColStart; d < boxColStart + sqrt; d++)  
			{ 
				if (board[r][d] == num)  
				{ 
					return false; 
				} 
			} 
		} 
			
	}
	
	

	public static boolean solveSudoku(int[][] board,int N){
		boolean isEmpty = true;
		int row=-1;
		int col=-1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j]== 0){
					isEmpty = false;
					
					row=i;
					col=j;
					
					break;
				}
			}
		}
		
		//All the elements are visited.
		if(isEmpty == true)
			return true;
		
		//Try all possible choices
		for(int num=1; num<=n; num++){
			if(isSafe(board,N,row,col,num)){
				board[row][col]=num;
				if(solveSudoku(board,N)){
					return true;
				}
				//backtrack
				board[row][col]=0;
			}
		}
		return false;
	}

	public static void main(String[] args){
		int[][] board = new int[][] 
		{ 
            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
		};

		int N = board.length;
		if(solveSudoku(board,N)){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(board[i][j]+"");
				}
				System.out.println();
			}
		}else{
			System.out.println("No Solution");
		}
	}
		
		
}
	
