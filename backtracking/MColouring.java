package backtracking;

class MColouring{
	
	static boolean isSafe(int[][] graph, int[] colours,int numVertex, int currVertex, int currColour){
		for(int i=0;i<numVertex;i++){
			if(graph[currVertex][i] == 1 && currColour == colours[i]){
				return false;
			}
		}
		return true;
	}
	
	
	static boolean graphColouringUtil(int[][] graph,int m,int numVertex,int[] colours, int currVertex){
	
		//Terminating condition
		if(currVertex == numVertex)
			return true;
		
		//Explore all choices
		for(int i=0;i<m;i++){
			
			if(isSafe(graph,colours,numVertex,currVertex,i)){
				colours[currVertex]=i;
				if(graphColouringUtil(graph,m,numVertex,colours,currVertex+1))
					return true;
				
				//backtrack
				colours[currVertex]=i;
			}
		}
		return false;
	}
	
	
	static void graphColouring(int[][] graph,int m){
		int numVertex=graph.length;
		int colours[] = new int[numVertex];
		
		for(int i=0;i<numVertex;i++){
			colours[i]=-1;
		}
		
		graphColouringUtil(graph,m,numVertex,colours,0);
		//PRINT SOl
		for(int i=0;i<numVertex;i++)
			System.out.println(" "+colours[i]);
	}	
	
	public static void main(String[] args){
		int graph[][] = {{0, 1, 1, 1}, 
            {1, 0, 1, 0}, 
            {1, 1, 0, 1}, 
            {1, 0, 1, 0}, 
        }; 
		int m=3;
		graphColouring(graph,m);
	}
}
