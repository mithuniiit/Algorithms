import java.beans.Visibility;
import java.util.Iterator;
import java.util.LinkedList;

public class BFSinGraph {

	private int v; //Number of Nodes
	private LinkedList<Integer>  adj[];
	
	BFSinGraph(int v){
	  this.v = v;
	  adj = new LinkedList[v];
	  for(int i=0;i<v;i++) {
		  adj[i] = new LinkedList<Integer>();
	  }
	}
	
	void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
	
	void printBfs(int s) {
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<v;i++) {
			visited[i]=false;
		}
		
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()) {
			int edge = queue.poll();
			System.out.println(edge);
			//iterate through all the edges in the adj list
			Iterator<Integer> i = adj[edge].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFSinGraph g = new BFSinGraph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        g.printBfs(2);
	}
	
	
}
