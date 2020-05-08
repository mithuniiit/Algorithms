package graphs;

public class PetersonGraph {

	static class graph{
		int adj[][];
		int V;
		char[] result;

		graph(int V){
			this.V = V;
			adj = new int[V][V];
			result = new char[10 * V];
		}

		void addEdge(int src,int dest) {
			adj[src][dest] = 1;
		}

		boolean findPath(char[] S, int v) {

			result[0] = (char)(v + '0');

			for(int i=1 ;i<S.length; i++) {
				if(adj[v][S[i]-'A'] == 1 || adj[S[i]-'A'][v]==1) {
					v = S[i] - 'A';
				}else if(adj[v][S[i]-'A'+5] == 1 || adj[S[i]-'A'+5][v]==1) {
					v = S[i] - 'A' + 5;
				}else
					return false;
				result[i] = (char)(v + '0');
			}
			return true;
		}
	}

	public static void main(String[] args) {
		graph g = new graph(10);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,0);
		g.addEdge(0,5);
		g.addEdge(1,6);
		g.addEdge(2,7);
		g.addEdge(3,8);
		g.addEdge(4,9);
		g.addEdge(5,7);
		g.addEdge(7,9);
		g.addEdge(9,6);
		g.addEdge(6,8);
		g.addEdge(8,5);

		char S[] = "ABB".toCharArray();

		if(g.findPath(S,S[0] - 'A') || g.findPath(S,S[0] - 'A' + 5)) {
			System.out.println(g.result);
		}else
			System.out.println("No Output");
	}

}
