package graphs;

import java.util.ArrayList;

public class CountNonAccessiblePositionsInMatrix {

	static class graph{
		int N;
		ArrayList<ArrayList<Integer>>adj;
		boolean isVisited[];


		graph(int N){
			this.N = N;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N*N;i++) {
				adj.add(new ArrayList<Integer>());
			}
			isVisited = new boolean[N*N];
		}

		void addEdge(int x1, int y1, int x2, int y2) {
			int u = (x1-1)*N+(y1-1);
			int v = (x2-1)*N+(y2-1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		int dfs(int u) {
			int count = 1;
			isVisited[u] = true;
			for(Integer v : adj.get(u)) {
				if(!isVisited[v]) {
					count += dfs(v);
				}
			}
			return count;
		}

		int numberOfNodes() {
			int count = 0;
			int answer = 0;
			
			for(int i=0; i<N*N; i++) {
				if(!isVisited[i]) {
					count = dfs(i);
					answer += (count * (N*N-count));
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		graph g = new graph(2);

		g.addEdge(1,1,1,2);
		g.addEdge(1,2,2,2);
		
		System.out.println(g.numberOfNodes());
	}
}