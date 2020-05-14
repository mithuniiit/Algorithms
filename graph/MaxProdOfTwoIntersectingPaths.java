package graphs;

import java.util.ArrayList;

public class MaxProdOfTwoIntersectingPaths {
	static class graph{
		int V;
		int curMax;
		ArrayList<ArrayList<Integer>>adj;
		
		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<V;i++) {
				adj.add(new ArrayList<Integer>());
			}
			curMax = 0;
		}
		
		void addEdge(int src, int dest) {
			adj.get(src).add(dest);
			adj.get(dest).add(src);
		}
		
		int dfs(int u, int v) {
			int max1=0, max2=0, total=0;
			for(Integer z : adj.get(u)) {
				if(z == v)
					continue;
				
				total = Math.max(total, dfs(z,u));
				if(curMax > max1) {
					max2 = max1;
					max1 = curMax;
				} else
					max2 = Math.max(max2, curMax);
			}
			
			total = Math.max(total,max1+max2);
			curMax = max1 + 1;
			return total;
		}
		
		void maxProductOfTwoPaths() {
			int res = Integer.MIN_VALUE;
			for(int u=0 ; u<V; u++) {
				for(Integer v: adj.get(u)) {
					curMax = 0; 
					int path1 = dfs(u,v);
					curMax = 0; 
					int path2 = dfs(v,u);
					res = Math.max(res,path1*path2);
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(4);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		
//		g.addEdge(0,7);
//		g.addEdge(1,5);
//		g.addEdge(2,0);
//		g.addEdge(4,2);
//		g.addEdge(6,7);
//		g.addEdge(7,3);
//		g.addEdge(7,5);
		g.maxProductOfTwoPaths();
	}
}
