package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class TranstiveClosure {

	ArrayList<ArrayList<Integer>> adj;
	int V;
	boolean trans[][];
	
	public TranstiveClosure(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V; i++)
			adj.add(new ArrayList<Integer>());
		trans = new boolean[V][V];
	}
	
	private void addEdge(int src, int dest) {
		adj.get(src).add(dest);
	}
	
	
	private void dfs(int src, int dest) {
		trans[src][dest] = true;
		
		for(Integer adj : adj.get(dest)) {
			if(trans[src][adj] == false) {
				dfs(src,adj);
			}
		}
	}

	private void computeTransClosure() {
		for(int i=0 ;i<V; i++) {
			dfs(i,i);
		}
		
		for(int i=0; i<V; i++)
			System.out.println(Arrays.toString(trans[i]));
		
	}
	
	
	public static void main(String[] args) {
		
		TranstiveClosure g = new TranstiveClosure(4);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.computeTransClosure();
	}
}
