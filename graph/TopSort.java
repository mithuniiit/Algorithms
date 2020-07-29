package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopSort {

	static class graph{
		int V;
		Stack<Integer> s;
		ArrayList<ArrayList<Integer>> adj;
		boolean isVisited[];

		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			s = new Stack<Integer>();
			isVisited = new boolean[V];
		}

		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
		}

		public void topSortUtil(int src) {
			isVisited[src] = true;
			for(Integer v : adj.get(src)) {
				if(!isVisited[v]) {
					topSortUtil(v);
				}
			}
			s.push(src);
		}

		public void topSort() {
			for(int i=0;i<V;i++) {
				if(!isVisited[i]) {
					topSortUtil(i);
				}
			}
		}

		public void print() {
			while(!s.isEmpty()) {
				System.out.println(s.pop());
			}
		}
	}

	public static void main(String[] args) {
		graph g = new graph(6);
		g.addEdge(5, 2);  
		g.addEdge(5, 0);  
		g.addEdge(4, 0);  
		g.addEdge(4, 1);  
		g.addEdge(2, 3);  
		g.addEdge(3, 1);  
		g.topSort();
		g.print();
	}
}
