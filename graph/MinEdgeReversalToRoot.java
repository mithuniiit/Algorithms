package graphs;

import java.util.ArrayList;

public class MinEdgeReversalToRoot {

	static class graph{
		int V;
		ArrayList<ArrayList<Edge>> adj;
		//First is dis and second is number of reverse node
		Pair dist[];
		boolean isVisited[];
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Edge>>();
			for(int i=0 ; i<V; i++) {
				adj.add(new ArrayList<Edge>());
			}
			//First is dis and second is number of reverse node
			dist = new Pair[V];
			for(int i=0; i<V; i++) {
				dist[i] = new Pair(0,0);
			}
			isVisited = new boolean[V];
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(new Edge(dest,0));
			adj.get(dest).add(new Edge(src,1));
		}
		
		int dfs(int u) {
			isVisited[u] = true;
			int totalRev = 0;
			
			for(Edge v : adj.get(u)) {
				if(!isVisited[v.vertex]) {
					dist[v.vertex].dist = dist[u].dist + 1;
					dist[v.vertex].noOfBackEdge = dist[u].noOfBackEdge;
					
					if(v.backEdge != 0) {
						dist[v.vertex].noOfBackEdge = dist[u].noOfBackEdge + 1;
						totalRev++;
					}
					totalRev += dfs(v.vertex);
				}
			}
			
			return totalRev;
		}
		
		void printMinEdgeReverseForRootNode() {
			
			// 0 is the source vertex
			dist[0].dist = 0;
			dist[0].noOfBackEdge = 0;
			
			int totalRev = dfs(0);
			
			int root = 0;
			int res = Integer.MAX_VALUE;
			
			for(int i=0 ; i<V; i++) {
				int edgesToReverse = (totalRev - dist[i].noOfBackEdge) + (dist[i].dist - dist[i].noOfBackEdge);
				if (edgesToReverse < res) {
					res = edgesToReverse;
					root = i;
				}
			}
			
			System.out.println("root = "+root);
		}
	}
	
	static class Pair{
		int dist;
		int noOfBackEdge;
		
		Pair(int dist, int noOfBackEdge){
			this.dist = dist;
			this.noOfBackEdge = noOfBackEdge;
		}
	}
	
	static class Edge{
		int vertex;
		int backEdge;
		Edge(int vertex, int backEdge){
			this.vertex = vertex;
			this.backEdge = backEdge;
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(8);
		g.addEdge(0,1);
		g.addEdge(2,1);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.addEdge(5,4);
		g.addEdge(5,6);
		g.addEdge(7,6);
		g.printMinEdgeReverseForRootNode();
	}
}
