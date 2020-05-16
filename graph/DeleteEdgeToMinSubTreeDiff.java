package graphs;

import java.util.ArrayList;

public class DeleteEdgeToMinSubTreeDiff {

	static class graph{
		int V;
		ArrayList<ArrayList<Integer>>adj;
		int result;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<V; i++) {
				adj.add(new ArrayList<Integer>());
			}
			result = Integer.MAX_VALUE;
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}

		void dfsUtil(int u, int parent, int []vertex, int vertexSum) {
			int total = vertex[u];
			
			for(Integer v : adj.get(u)) {
				if(v != parent) {
					dfsUtil(v,u,vertex,vertexSum);
					total += vertex[v];
				}
			}
			
			vertex[u] = total;
			
			result = Math.min(result, Math.abs(vertexSum - 2*total));
		}
		
		int getMinSubtreeSumDifference(int[] vertex) {
			int vertexSum = 0;
			for(int i=0; i<vertex.length; i++) {
				vertexSum += vertex[i];
			}
			dfsUtil(0,-1,vertex,vertexSum);
			return result;
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(7);
		int [] vertex = {4, 2, 1, 6, 3, 5, 2};
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(2,4);
		g.addEdge(2,5);
		g.addEdge(3,6);
		System.out.println(g.getMinSubtreeSumDifference(vertex));
	}
}
