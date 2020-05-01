package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class StonglyConnectedGraphKosaraju {

	ArrayList<ArrayList<Integer>> adj;
	boolean isVisited[];
	int V;
	
	StonglyConnectedGraphKosaraju(int V){
		this.V = V;
		isVisited = new boolean[V];
		adj = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0 ;i<V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	
	public void fillOrder(int vertex , Stack<Integer> s) {
		isVisited[vertex] = true;
		
		for(Integer i : adj.get(vertex)) {
			if(!isVisited[i]) {
				fillOrder( i , s);
			}
		}

		s.push(vertex);
	}
	
	
	public ArrayList<ArrayList<Integer>> transpose() {
		
		ArrayList<ArrayList<Integer>> transGraph = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V; i++) {
			transGraph.add(new ArrayList<Integer>());
		}
		
		for(int i=0 ; i<adj.size(); i++) {
			for(Integer vertex : adj.get(i)) {
				transGraph.get(vertex).add(i);
			}
		}
		
		return transGraph;
	}
	
	
	public void dfs(int vertex, ArrayList<ArrayList<Integer>> transGraph ) {
		isVisited[vertex] = true;
		System.out.println(" " + vertex);
		for(Integer i : transGraph.get(vertex)) {
			if(!isVisited[i])
				dfs(i,transGraph);
		}
	}
	
	public void printSCC() {
		Stack<Integer> s = new Stack<>();
		
		//Fill the stack with order of nodes without outgoing edges.
		fillOrder(0,s);
		
		//Reverse the edges by creating another graph
		ArrayList<ArrayList<Integer>> transGraph = transpose();
		
		//Reset the boolean array
		for(int i=0; i<V; i++) {
			isVisited[i] = false;
		}
		
		//Now pop each element from the stack and do DFS
		while(!s.isEmpty()) {
			int vertex = s.pop();
			if(!isVisited[vertex]) {
				dfs(vertex, transGraph);
			}
			System.out.println();
		}
	}
	
	public void addEdge(int src, int dest) {
		adj.get(src).add(dest);
	}
	
	public static void main(String[] args) {
		StonglyConnectedGraphKosaraju g = new StonglyConnectedGraphKosaraju(5);
		g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 
	    
	    g.printSCC();
	}
}
