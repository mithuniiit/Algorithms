package graphs;

import java.util.ArrayList;

public class MotherVertex {
	
	boolean isVisited[];
	ArrayList<ArrayList<Integer>> adj;
	int V;
	
	public MotherVertex(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		isVisited = new boolean[V];
	}
	
	public void DFS(int src) {
		isVisited[src] = true;
		for(Integer i : adj.get(src)) {
			if(!isVisited[i])
				DFS(i);
		}
	}
	
	public void findMother() {
		int motherVertex = Integer.MIN_VALUE;
		
		for(int i=0; i<V; i++) {
			if(!isVisited[i]) {
				DFS(i);
				motherVertex = i;
			}
		}
		
		//if it is a mother vertex we should be able to reach all vertex now
		for(int i=0; i<V ;i++) {
			isVisited[i] = false;
		}
		
		DFS(motherVertex);
		for(int i=0; i<V ;i++) {
			if(isVisited[i] == false) {
				motherVertex = -1;
			}
		}
		
		System.out.println(motherVertex);
	}
	
	
	public void addEdge(int src, int dest) {
		adj.get(src).add(dest);
	}
	
	public static void main(String[] args) {
		
		MotherVertex mv = new MotherVertex(7);
		mv.addEdge(0, 1); 
		mv.addEdge(0, 2); 
		mv.addEdge(1, 3); 
		mv.addEdge(4, 1); 
		mv.addEdge(6, 4); 
		mv.addEdge(5, 6); 
		mv.addEdge(5, 2); 
		mv.addEdge(6, 0);
		
		mv.findMother();
	}

}
