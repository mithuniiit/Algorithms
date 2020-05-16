package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinMovesToReachSrcToDest {
	
	static class graph{
		int V;
		LinkedList<Integer> adj[];
		
		graph(int V){
			this.V = V;
			adj = new LinkedList[V]; 
			for(int i=0; i<V; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int src, int dest) {
			adj[src].add(dest);
		}
		
		boolean isSafe(int [][]M, int i, int j,int N) {
			if(i>=0 && i<N && j>=0 && j<N && M[i][j] != 0) {
				return true;
			}
			return false;
		}
		
		
		void bfsUtil(int src,int dest) {
			
			int [] level = new int[V];
			for(int i=0; i<V; i++)
				level[i] = -1;
			
			level[src] = 0;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(src);
			
			while(!q.isEmpty()) {
				int u = q.poll();
				
				for(Integer v : adj[u]) {
					if(level[v] == -1 || level[v] > level[u]+1) {
						level[v] = level[u]+1;
						q.add(v);
					}
				}
			}
			
			System.out.println(level[dest]);
		}
		
		void bfs(int [][]M, int N) {
			int k = 0;
			int src  = 0, dest=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(M[i][j]!=0) {
					
						if(isSafe(M,i,j+1,N)) {
							addEdge(k,k+1);
						}
						
						if(isSafe(M,i,j-1,N)) {
							addEdge(k,k-1);
						}
						
						if(isSafe(M,i+1,j,N)) {
							addEdge(k+N,k);
						}
						
						if(isSafe(M,i-1,j,N)) {
							addEdge(k-N,k);
						}
					}
					
					if(M[i][j] == 1)
						src = k;
					
					if(M[i][j] == 2)
						dest = k;
					
					k++;
				}
			}
			
			bfsUtil(src,dest);
		}
		
		void printMoves(int[][] M, int N) {
			//add edges to edge list
			bfs(M,N);
			
			System.out.println("DONE");
		}
	}

	
	public static void main(String[] args) {
		int N = 4;
		
		int M[][] = {
				{ 3 , 3 , 1 , 0 }, 
		        { 3 , 0 , 3 , 3 }, 
		        { 2 , 3 , 0 , 3 }, 
		        { 0 , 3 , 3 , 3 } 
		    };
		graph g = new graph(4*4);
		g.printMoves(M, N);
	}
}
