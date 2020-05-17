//https://www.geeksforgeeks.org/clone-an-undirected-graph/
package graphs;

import java.util.ArrayList;

public class CloneGraph {

	static class graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		ArrayList<ArrayList<Integer>>clone;

		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i = 0;i <V; i++) {
				adj.add(new ArrayList<Integer>());
			}

			clone = new ArrayList<ArrayList<Integer>>();
			for(int i = 0;i <V; i++) {
				clone.add(new ArrayList<Integer>());
			}
		}

		void addEdge(int src,int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}

		void cloneGraph() {
			for(int u = 0; u<V; u++) {
				for(Integer v : adj.get(u)) {
					clone.get(u).add(v);
				}
			}
		}

	}

	public static void main(String[] args) {
		graph g = new graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(2,3);
		g.cloneGraph();
	}
}
