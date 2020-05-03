package graphs;

import java.util.ArrayList;

public class CountTreeInForest {
	static class Graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		boolean isVisited[];

		Graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) 
				adj.add(new ArrayList<Integer>());
			isVisited = new boolean[V];
		}

		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
		}


		void DFSUtil(int vertex) {
			isVisited[vertex] = true;
			for(int i : adj.get(vertex)) {
				if(!isVisited[i]) {
					DFSUtil(i);
				}
			}
		}


		int countTree() {
			int count = 0;
			for(int i=0; i<V; i++) {
				if(!isVisited[i]) {
					DFSUtil(i);
					count++;
				}
			}
			return count;	
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);  
		g.addEdge(0, 2);  
		g.addEdge(3, 4);
		System.out.println(g.countTree());
	}
}
