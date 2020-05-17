//https://www.geeksforgeeks.org/roots-tree-gives-minimum-height/
package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RootOfATreeWithMinHeight {

	static class graph{
		 int V;
		 ArrayList<ArrayList<Integer>>adj;
		 int []degree;
		 
		 graph(int V){
			 this.V = V;
			 adj = new ArrayList<ArrayList<Integer>>();
			 for(int i = 0;i <V; i++) {
				 adj.add(new ArrayList<Integer>());
			 }
			 degree = new int[V];
		 }
		 
		 void addEdge(int src, int dest) {
			 adj.get(src).add(dest);
			 adj.get(dest).add(src);
			 degree[src]++;
			 degree[dest]++;
		 }
		 
		 void findRoot() {
			 Queue<Integer> q = new LinkedList();
			 
			 //Add all the leaf nodes
			 for(int i=0; i<V; i++) {
				 if(degree[i] == 1) {
					 q.add(i);
				 }
			 }
			 
			 while(!q.isEmpty() && V>2) {
				 int u = q.poll();
				 V--;
				 for(Integer v : adj.get(u)) {
					 degree[v]--;
					 if(degree[v] == 1)
						 q.add(v);
				 }
			 }
			 
			 while(!q.isEmpty()) {
				 System.out.println(q.poll());
			 }
		 }
	}
	
	public static void main(String[] args) {
		graph g = new graph(6);
	    g.addEdge(0, 3); 
	    g.addEdge(1, 3); 
	    g.addEdge(2, 3); 
	    g.addEdge(4, 3); 
	    g.addEdge(5, 4); 
	    g.findRoot();
	}
}
