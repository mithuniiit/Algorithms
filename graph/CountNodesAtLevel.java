package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNodesAtLevel {

	static class Graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		int count[];
		int level[];
		boolean isVisited[];
		
		
		Graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			count = new int[V];
			isVisited = new boolean[V];
			count = new int[V];
			level = new int[V];
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
		void BFS(int src, int l) {
			isVisited[src] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(src);
			level[src] = 0;
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				for(Integer i : adj.get(temp)) {
					if(!isVisited[i]) {
						q.add(i);
						level[i] = level[temp]+1;
						isVisited[i] = true;
					}
				}
			}
			
			int count = 0;
			for(int i=0; i<V; i++) {
				if(level[i] == l)
					count++;
			}
			
			System.out.println("Count = "+count);
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6); 
		int l = 2;
	    g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(2, 4); 
	    g.addEdge(2, 5);
	    g.BFS(0,l);
	}
}
