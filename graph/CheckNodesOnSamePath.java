//https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/

package graphs;

import java.util.ArrayList;

public class CheckNodesOnSamePath {
	
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		boolean []isVisited;
		int []inTime;
		int []outTime;
		int timer;
		
		graph(int V){
			this.V = V+1;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i = 0;i<this.V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			isVisited = new boolean[this.V];
			inTime = new int[this.V];
			outTime = new int[this.V];
			timer = 0;
		}
		
		void dfs(int u) {
			inTime[u] = ++timer;
			isVisited[u] = true;
			
			for(Integer v : adj.get(u)) {
				if(!isVisited[v]) {
					dfs(v);
				}
			}
			outTime[u] = ++timer;
		}
		
		void addEdge(int src,int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
		boolean query(int src, int dest) {
			
			if(inTime[src] < inTime[dest] && outTime[dest] < outTime[src])
				return true;
			return false;
		}
	}
	
	public static void main(String[] args) {
	    graph g = new graph(10);
	    g.addEdge(1, 2); 
	    g.addEdge(1, 3);
	    g.addEdge(3, 6);
	    g.addEdge(2, 4);
	    g.addEdge(2, 5);
	    g.addEdge(5, 7);
	    g.addEdge(5, 8);
	    g.addEdge(5, 9);
	    g.dfs(1);
	    
	    System.out.println(g.query(1,5));
	    System.out.println(g.query(2,9));
	    System.out.println(g.query(2,6));
	}
}
