package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
	static class Graph{
		int [][] adj;
		int V;
		int [] colours;
		
		public Graph(int V) {
			this.V = V;
			adj = new int[V][V];
			colours = new int[V];
			for(int i =0;i<V;i++) {
				colours[i] = -1;
			}
		}
		
		public void addEdge(int src,int dest) {
			adj[src][dest] = 1;
		}
		
		public boolean isBipartiteBFSUtil(int src) {
			Queue<Integer> q = new LinkedList<>();
			q.add(src);
			colours[src]=0;
			
			while(!q.isEmpty()) {
				int node = q.poll();
				for(int i=0; i<V; i++) {
					if(adj[node][i] == 1 && colours[i] == -1 ) {
						colours[i] = 1 - colours[node];
						q.add(i);
					}else if(adj[node][i] == 1 && colours[i] == colours[node]) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		public boolean isBipartiteDFSUtil(int src) {
			if(colours[src] == -1) {
				colours[src] = 0;
				for(int i=0 ; i<V; i++) {
					if(adj[src][i] == 1 && colours[i] == -1) {
						return isBipartiteDFSUtil(i);
					}else if(adj[src][i] == 1 && colours[i] == colours[src]) {
						return false;
					}
				}
			}
			return true;
		}
		
		public boolean isBipartiteBFS() {
			for(int i=0;i<V;i++) {
				if(colours[i] == -1) {
					if(isBipartiteBFSUtil(i)==false)
						return false;
				}
			}
			return true;
		}
		
		public boolean isBipartiteDFS() {
			for(int i=0;i<V;i++) {
				if(colours[i] == -1) { 
					if(isBipartiteDFSUtil(i)==false)
						return false;
				}
			}
			return true;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0,1);
		g.addEdge(0,5);
		g.addEdge(1,0);
		g.addEdge(1,2);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.addEdge(4,3);
		g.addEdge(4,5);
		g.addEdge(5,0);
		g.addEdge(5,4);
		System.out.println(g.isBipartiteBFS());
		System.out.println(g.isBipartiteDFS());
	}
}
