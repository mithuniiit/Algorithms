package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfEachNodeInGraph {
	
	static class graph{
		ArrayList<ArrayList<Integer>> adj;
		int level[];
		int V;
		boolean isVisited[];
		Queue<Integer> q;
		
		graph(int V) {
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>(V);
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<>());
			}
			level = new int[V];
			isVisited = new boolean[V];
			q = new LinkedList();
		}
		
		void addNode(int src, int dest) {
			adj.get(src).add(dest);
		}
		
		void computeLevel(int src) {
			q.add(src);
			isVisited[src] = true;
			level[src] = 0;
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				for(Integer i : adj.get(temp)) {
					if(!isVisited[i]) {
						q.add(i);
						isVisited[i] = true;
						level[i] = level[temp]+1;
					}
				}
			}
			
			for(int i=0; i<V; i++)
				System.out.println(i + "--->" + level[i]);
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(8);
		g.addNode(0,1);
		g.addNode(0,2);
		g.addNode(1,3);
		g.addNode(1,4);
		g.addNode(1,5);
		g.addNode(2,5);
		g.addNode(2,6);
		g.addNode(6,7);
		g.computeLevel(0);
	}
}
