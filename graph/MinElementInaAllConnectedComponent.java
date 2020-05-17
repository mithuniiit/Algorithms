//https://www.geeksforgeeks.org/sum-of-the-minimum-elements-in-all-connected-components-of-an-undirected-graph/

package graphs;

import java.util.ArrayList;

public class MinElementInaAllConnectedComponent {
	
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		boolean []isVisited;
		//int min;

		graph(int V){
			this.V = V+1;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i = 0;i<this.V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			isVisited = new boolean[this.V];
		}
		
		void addEdge(int src,int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
		int dfs(int u) {
			
			int min = Math.min(u,Integer.MAX_VALUE);
			
			isVisited[u] = true;
			for(Integer v : adj.get(u)) {
				if(!isVisited[v]) {
					int temp = dfs(v);
					if(min > temp)
						min = dfs(v);
				}
			}
			
			return min;
		}
		
		void findMin(int []a) {
			int sum = 0;
			for(int i=0;i<a.length;i++) {
				if(!isVisited[a[i]]) {
					sum += dfs(a[i]);
				}
			}
			System.out.println("Min Sum is "+sum);
		}
	}
	
	public static void main(String[] args) {
	    int a[] = {1, 6, 2, 7, 3, 8, 4, 9, 5, 10};
	    graph g = new graph(10);
	    g.addEdge(1, 2); 
	    g.addEdge(3, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(7, 8); 
	    g.addEdge(9, 10); 
	    g.findMin(a);
	}
}
