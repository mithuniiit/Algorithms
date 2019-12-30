package backtracking;

class KnightTour{
	
	static int N=8;
	static Integer board[][] = new Integer[N][N];
	static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
	
	public static boolean isSafe(int i,int j, Integer[][] board){
		return (i>=0 && i<=N && j>=0 && j<=N && board[i][j] != -1);
	}
	
	public static void main(String[] args){
		solveKT();
	}
	
	public static void solveKT(){
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[i][j]=-1;
			}
		}	
		board[0][0] = 0;
		
		if(!solveKTUtil(board,0,0,1))
			System.out.println("No Sol");
	}
	
	public static boolean solveKTUtil(Integer[][] board,int x,int y, int count){
		if(count == N*N)
			return true;
		
		for(int k=0;k<8;k++){
			int newX = x+xMove[k];
			int newY = y+yMove[k];
			if(isSafe(newX,newY,board)){
				board[newX][newY]=count;
				if(solveKTUtil(board,newX,newY,count+1))
					return true;
				else
					board[newX][newY] = -1; //backtrack
			}
		}	
		return false;
	}
}		
