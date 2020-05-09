package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsDisconnected {

	int v;
	ArrayList<ArrayList<Integer>> adj;
	boolean isVisited[];
	
	BfsDisconnected(int v) {
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>(this.v);
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		 isVisited = new boolean[v];
	}
	
	
	public void printBfsUtil (int src) {
		Queue<Integer> q = new LinkedList<>();
		
		
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
	

	public void printBfs(int src) {
		printBfsUtil(src);
		
		for(int i=0; i<v; i++) {
			if(!isVisited[i]) {
				printBfsUtil(i);
			}
		}
	}
	
	public void addEdge(int src, int dest) {
		adj.get(src).add(dest);
	}
	
	public static void main(String[] args) {
		BfsDisconnected b = new BfsDisconnected(5);
		b.addEdge(0,4);
		b.addEdge(1,2);
		b.addEdge(1,3);
		b.addEdge(1,4);
		b.addEdge(2,3);
		b.addEdge(3,4);
		
		b.printBfs(0);
	}
}
