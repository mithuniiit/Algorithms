package graphs;

import java.util.ArrayList;

public class dfs {

	int v;
	ArrayList<ArrayList<Integer>> adj;
	boolean visited[];
	
	dfs(int v){
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		for(int i=0 ;i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		visited = new boolean[v];
	}
	
	public void print(int vertex) {
		visited[vertex] = true;
		System.out.println(vertex);
		for(Integer i : adj.get(vertex)) {
			if(!visited[i]) {
				print(i);
			}
		}
	}
	
	public void addEdge(int src, int dest) {
		adj.get(src).add(dest);
		adj.get(dest).add(src);
	}
	
	public static void main(String[] args) {
		dfs d = new dfs(4);
		
		d.addEdge(0,1);
		d.addEdge(0,2);
		d.addEdge(1,2);
		d.addEdge(2,3);
		d.addEdge(3,3);
		
		d.print(0);
	}
}
