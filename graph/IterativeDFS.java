package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

	static class Graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		Stack<Integer> s;
		boolean isVisited[];
		
		Graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			s = new Stack<Integer>();
			isVisited = new boolean[V];
		}

		public void addEdge(int src, int dest) {
			adj.get(src).add(dest);
		}
		
		public void DFS() {
			for(int i=0; i<V; i++) {
				if(!isVisited[i])
					DFSUtil(i);
			}
		}
		
		public void DFSUtil(int src) {
			s.push(src);
			
			while(!s.isEmpty()) {
				int temp = s.pop();
				isVisited[temp] = true;
				System.out.println(temp);
				for(Integer i : adj.get(temp)) {
					if(!isVisited[i])
						s.push(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5); 
        g.addEdge(1, 0); 
        g.addEdge(2, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4); 
        g.addEdge(4, 0);
        g.DFS();
	}
}
