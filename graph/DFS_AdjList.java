package greedy;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS_AdjList {
	
	static class Graph{
		int V;
		LinkedList<Integer> adjList[];
		boolean visited[];
		
		public Graph(int V) {
			this.V=V;
			adjList=new LinkedList[V];
			for(int i=0;i<V;i++) {
				adjList[i] = new LinkedList<>();
			}
			visited = new boolean[V];
		}
		
		public void addEdge(int src,int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);
		}
		
		public void dfs(int src) {
			visited[src]=true;
			System.out.println(src);
			Iterator<Integer> i = adjList[src].listIterator();
			while(i.hasNext()) {
				int vertex = i.next();
				if(!visited[vertex]) {
					dfs(vertex);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        
        g.dfs(0);
	}

}
