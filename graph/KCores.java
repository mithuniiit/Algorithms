package graphs;

public class KCores {

	int[][] adj;
	int V;
	int degree[];

	KCores(int v){
		this.V = v;
		adj = new int[V][V];
		degree = new int[V];
	}

	private int findMin(int k) {
		for(int i=0 ;i<V; i++) {
			if(degree[i] != -1 && degree[i] < k )
				return i;
		}
		return -1;
	}

	private void printKCores(int k) {
		int minVertex = -1;

		while((minVertex = findMin(k)) != -1) {
			degree[minVertex] = -1;
			
			for(int j=0; j<V; j++) {
				if(adj[minVertex][j] == 1) {
					adj[minVertex][j] = 0;
					adj[j][minVertex] = 0;
					degree[j]--;
				}
			}
		}
		
		for(int i=0; i<V; i++) {
			System.out.println();
			System.out.print(i + " --> ");
			for( int j=0 ; j<V; j++) {
				if(adj[i][j] == 1)
					System.out.print(" "+ j);
			}
		}
	}

	private void addEdge(int src, int dest) {
		adj[src][dest] = 1;
		adj[dest][src] = 1;
		degree[src]++;
		degree[dest]++;
	}

	public static void main(String[] args) {
		int k = 3;
		KCores g1 = new KCores(9);
		g1.addEdge(0, 1); 
		g1.addEdge(0, 2); 
		g1.addEdge(1, 2); 
		g1.addEdge(1, 5); 
		g1.addEdge(2, 3); 
		g1.addEdge(2, 4); 
		g1.addEdge(2, 5); 
		g1.addEdge(2, 6); 
		g1.addEdge(3, 4); 
		g1.addEdge(3, 6); 
		g1.addEdge(3, 7); 
		g1.addEdge(4, 6); 
		g1.addEdge(4, 7); 
		g1.addEdge(5, 6); 
		g1.addEdge(5, 8); 
		g1.addEdge(6, 7); 
		g1.addEdge(6, 8); 
		g1.printKCores(k); 
	}
}
