package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

	int v;
	ArrayList<ArrayList<Integer>> adj;
	
	bfs(int v) {
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>(this.v);
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	
	public void printBfs (int src) {
		Queue<Integer> q = new LinkedList<>();
		boolean isVisited[] = new boolean[v];
		
		isVisited[src] = true;
		q.add(src);
		
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			System.out.println(vertex);
			for(Integer i : adj.get(vertex) ) {
				if(!isVisited[i]) {
					q.add(i);
					isVisited[i] = true;
				}
					
			}
		}
	}
	
	
	public void addEdge(int src, int dest) {
		adj.get(src).add(dest);
		adj.get(dest).add(src);
	}
	
	public static void main(String[] args) {
		bfs b = new bfs(4);
		b.addEdge(0,1);
		b.addEdge(0,2);
		b.addEdge(1,2);
		b.addEdge(2,0);
		b.addEdge(2,3);
		b.addEdge(3,3);
		
		b.printBfs(0);
	}
}
