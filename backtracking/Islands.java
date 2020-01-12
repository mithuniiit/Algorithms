package backtracking;

class Island{

    static int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
    static int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 

    public static boolean isSafe(int[][] graph, boolean[][] visited, int M,int N, int rowi, int coli){
        if(rowi>=0 && rowi<M && coli>=0 && coli<N && visited[rowi][coli]==false && graph[rowi][coli]==1)
            return true;
        return false;
    }
    
    public static void DFSUtil(int[][] graph,boolean[][] visited, int M, int N, int row, int col){
        for(int i=0;i<8;i++){
            if(isSafe(graph,visited,M,N,row+rowNbr[i],col+colNbr[i])){
            	visited[row+rowNbr[i]][col+colNbr[i]]=true;
                DFSUtil(graph,visited,M,N,row+rowNbr[i],col+colNbr[i]);
            }
        }
    }

    public static int findIsland(int[][] graph, int M,int N){
        boolean[][] visited = new boolean[M][N];
        int count = 0;
        for(int row=0;row<M;row++){
            for(int col=0;col<N;col++){
                if(graph[row][col] == 1 && !visited[row][col]){
                    DFSUtil(graph,visited,M,N,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    
	public static void main(String[] args){
        int M=5,N=5;
        int graph[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
                                  { 0, 1, 0, 0, 1 }, 
                                  { 1, 0, 0, 1, 1 }, 
                                  { 0, 0, 0, 0, 0 }, 
                                  { 1, 0, 1, 0, 1 } 
                                }; 

        int count = findIsland(graph,M,N);
        System.out.println("Count ="+count);
    }
}
