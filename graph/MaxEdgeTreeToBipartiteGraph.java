package graphs;

import java.util.ArrayList;

public class MaxEdgeTreeToBipartiteGraph {

	static class graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		int []colours;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<V;i++)
				adj.add(new ArrayList<Integer>());
			colours = new int[2];
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
		}
		
		void dfs(int src,int c) {
			colours[c]++;
			for(Integer i : adj.get(src)) {
				dfs(i, c==0 ? 1 : 0);
			}
		}
		
		int findMaxEdge() {
			dfs(0,0);
			return colours[0] * colours[1] - (V-1); 
		}
	}
	

	public static void main(String[] args) {
		graph g = new graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(2,4);
		System.out.println(g.findMaxEdge());
	}

}
