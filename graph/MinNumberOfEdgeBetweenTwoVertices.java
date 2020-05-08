package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinNumberOfEdgeBetweenTwoVertices {
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		boolean isVisited[];
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0 ;i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			isVisited = new boolean[V];
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
		int findMin(int src, int dest) {
			Queue<Integer> q = new LinkedList();
			q.add(src);
			q.add(Integer.MIN_VALUE);
			int dist = 0;
			isVisited[src] = true;
			
			while(!q.isEmpty()) {
				int vertex = q.poll();
				if(vertex == dest)
					return dist;
				
				if(vertex == Integer.MIN_VALUE) {
					dist++;
					q.add(Integer.MIN_VALUE);
					continue;
				}
				
				for(Integer i : adj.get(vertex)) {
					if(!isVisited[i]) {
						q.add(i);
						isVisited[i] = true;
					}
				}
			}
			
			return dist;
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(9);
		g.addEdge(0,1);
		g.addEdge(0,7);
		g.addEdge(1,7);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,5);
		g.addEdge(2,8);
		g.addEdge(3,4);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(5,6);
		g.addEdge(6,7);
		g.addEdge(7,8);
		System.out.println(g.findMin(0,5));
	}
}
