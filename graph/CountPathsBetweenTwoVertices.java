package graphs;

import java.util.ArrayList;

public class CountPathsBetweenTwoVertices {

	static class Graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		boolean isVisited[];
		
		
		Graph(int V){
			this.V = V;
			isVisited = new boolean[V];
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++)
				adj.add(new ArrayList<Integer>());
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
		}
		
		
		int countPathUtil(int src, int dest, int np) {
			if(src == dest) {
				np++;
			}else {
				for(int i : adj.get(src)) {
					np = countPathUtil(i,dest,np);
				}
			}
			return np;
		}
		
		void countPath(int src, int dest) {
			System.out.println(countPathUtil(src, dest, 0));
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(1, 3); 
        g.addEdge(2, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 4); 
        g.countPath(0,3);
	}
}
