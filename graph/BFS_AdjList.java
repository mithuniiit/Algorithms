package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_AdjList {
	
	static class Graph{
		int V;
		LinkedList<Integer> adjList[];
		boolean visited[];
		Queue<Integer>queue = new LinkedList();
		public Graph(int V) {
			this.V=V;
			adjList = new LinkedList[V];
			for(int i=0;i<V;i++) {
				adjList[i]= new LinkedList<>();
			}
			visited = new boolean[V];
		}
		
		void addEdge(int src,int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);
		}
		
		void doBfs(int src) {
			queue.add(src);
			while(!queue.isEmpty()) {
				int vertex = queue.poll();
				if(!visited[vertex]) {
					System.out.println(vertex);
					visited[vertex] = true;
					//Append all adj nodes
					LinkedList<Integer> list = adjList[vertex];
					for(int i=0;i<list.size();i++) {
						int node = list.get(i);
						if(!visited[node])
							queue.add(node);
					}
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

        g.doBfs(0);
	}
}
