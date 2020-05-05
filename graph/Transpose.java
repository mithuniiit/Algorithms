package graphs;

import java.util.ArrayList;

public class Transpose {
	
	static class graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		ArrayList<ArrayList<Integer>> trans;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			
			trans = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				trans.add(new ArrayList<Integer>());
			}
		}
		
		void addEdge(int src, int dest, boolean flag) {
			if(!flag) {
				adj.get(src).add(dest);
			}else {
				trans.get(src).add(dest);
			}
		}
		
		void trans(){
			for(int i = 0; i<V; i++) {
				for(Integer vertex : adj.get(i)) {
					addEdge(vertex, i, true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		 graph g = new graph(5);
		 g.addEdge(0, 1, false); 
	     g.addEdge(0, 4, false); 
	     g.addEdge(0, 3, false); 
	     g.addEdge(2, 0, false); 
	     g.addEdge(3, 2, false); 
	     g.addEdge(4, 1, false); 
	     g.addEdge(4, 3, false);
	     g.trans();
	}
}
