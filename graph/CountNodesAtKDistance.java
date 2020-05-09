package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNodesAtKDistance {
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0 ;i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		

		int bfs(int src, ArrayList<Integer> dist) {
			boolean isVisited[] = new boolean[V];
			Queue<Integer> q = new LinkedList<>();
			int lastVisited = 0;
			q.add(src);
			isVisited[src] = true;
			dist.set(src,0);
			
			while(!q.isEmpty()) {
				int u = q.poll();
				isVisited[u] = true;
				for(Integer v : adj.get(u)) {
					if(!isVisited[v]) {
						q.add(v);
						lastVisited = v;
						dist.set(v, dist.get(u)+1);
					}
				}
			}
			
			return lastVisited;
		}
		
		int countNodes(int k) {
			/*
			 1. take a start vertex and find the max distant node
			 2. take that distent node and find next distant node
			 3. again bfs and find nodes at dist < K
			 */
			
			ArrayList<Integer> distU = new ArrayList<Integer>();
			ArrayList<Integer> distV = new ArrayList<Integer>();
			
			for(int i=0 ;i<V; i++) {
				distU.add(i,0);
				distV.add(i,0);
			}
			
			int leftVertex = bfs(0,distU);
			for(int i=0;i<V;i++)
				distU.set(i,0);
			int rightVertex = bfs(leftVertex,distU);
			bfs(rightVertex,distV);
			
			int count = 0;
			
			for(int i=0 ;i<V; i++) {
				if(distU.get(i) <= k && distV.get(i) <= k) {
					count++;
				}
			}
			
			return count;
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(10);
		g.addEdge(0,1);
		g.addEdge(0,8);
		g.addEdge(0,3);
		g.addEdge(3,2);
		g.addEdge(3,6);
		g.addEdge(3,7);
		g.addEdge(3,5);
		g.addEdge(5,4);
		g.addEdge(5,9);
		System.out.println(g.countNodes(3));
	}
}
