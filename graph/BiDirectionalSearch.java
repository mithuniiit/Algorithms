package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BiDirectionalSearch {

	static class graph{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<V ;i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}

		
		void bfs(Queue<Integer>queue, boolean visited[], int parent[]) {
			int u = queue.poll();
			for(Integer v : adj.get(u) ) {
				if(!visited[v]) {
					visited[v] = true;
					queue.add(v);
					parent[v] = u;
				}
			}
		}
		
		int findIntersection(boolean []s_visited, boolean []t_visited) {
			
			for(int i=0; i<V ; i++) {
				if(s_visited[i] && t_visited[i]) {
					return i;
				}
			}
			
			return -1;
		}
		
		
		void printPaths(int []s_parent, int []t_parent, int s, int t, int intersectionNode) {
			
			ArrayList<Integer> slist = new ArrayList<>();
			ArrayList<Integer> plist = new ArrayList<>();
			int i = intersectionNode;
			
			//s_parent
			while(i!=-1) {
				slist.add(i);
				i = s_parent[i];
			}
			Collections.reverse(slist);

			//t_parent
			i = intersectionNode;
			while(i!=-1) {
				plist.add(i);
				i = t_parent[i];
			}
			
			for(Integer u : slist)
				System.out.println(u);
			
			for(Integer p : plist)
				System.out.println(p);
		}
		
		int doBiDirSearch(int s, int t) {
			
			int intersectionNode = -1;
			
			boolean s_visited[] = new boolean[V];
			boolean t_visited[] = new boolean[V];
			Queue<Integer> s_queue = new LinkedList<Integer>();
			Queue<Integer> t_queue = new LinkedList<Integer>();
			int s_parent[] = new int[V];
			int t_parent[] = new int[V];
			
			s_queue.add(s);
			s_visited[s] = true;
			s_parent[s]= -1;
			
			t_queue.add(t);
			t_visited[t] = true;
			t_parent[t]= -1;
			
			
			while(!s_queue.isEmpty() && !t_queue.isEmpty()) {
				bfs(s_queue,s_visited,s_parent);
				bfs(t_queue,t_visited,t_parent);
				
				intersectionNode = findIntersection(s_visited, t_visited);
				
				if(intersectionNode != -1) {
					//print paths
					printPaths(s_parent,t_parent,s,t,intersectionNode);
					break;
				}
			}
			return -1;
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(15);
		g.addEdge(0,4);
	    g.addEdge(1, 4); 
	    g.addEdge(2, 5); 
	    g.addEdge(3, 5); 
	    g.addEdge(4, 6); 
	    g.addEdge(5, 6); 
	    g.addEdge(6, 7); 
	    g.addEdge(7, 8); 
	    g.addEdge(8, 9); 
	    g.addEdge(8, 10); 
	    g.addEdge(9, 11); 
	    g.addEdge(9, 12); 
	    g.addEdge(10, 13); 
	    g.addEdge(10, 14);
	    g.doBiDirSearch(0,14);
	}
}
