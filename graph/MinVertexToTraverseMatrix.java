package graphs;

import java.util.ArrayList;
import java.util.Collections;

public class MinVertexToTraverseMatrix {

	static class graph{
		int V;
		boolean isVisited[][];
		
		graph(int V){
			this.V = V;
			isVisited = new boolean[V][V];
		}
		
		static class ordinate{
			int wt;
			int x;
			int y;
			ordinate(int x, int y, int wt) {
				this.x = x;
				this.y = y;
				this.wt = wt;
			}
		}
		
		void dfsUtil(int x, int y, int [][]matrix) {
			isVisited[x][y] = true;
			
			if(x-1>=0 && !isVisited[x-1][y] && matrix[x][y] > matrix[x-1][y]) {
				dfsUtil(x-1,y,matrix);
			}
			
			if(x+1<V && !isVisited[x+1][y] && matrix[x][y] > matrix[x+1][y]) {
				dfsUtil(x+1,y,matrix);
			}
			
			if(y-1>=0 && !isVisited[x][y-1] && matrix[x][y] > matrix[x][y-1]) {
				dfsUtil(x,y-1,matrix);
			}
			
			if(y+1<V && !isVisited[x][y+1] && matrix[x][y] > matrix[x][y+1]) {
				dfsUtil(x,y+1,matrix);
			}
		}
		
		void dfs(int [][]matrix) {
			//populate ArrayList with pairs and sort based on weight
			ArrayList<ordinate> list = new ArrayList<>();
			
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					list.add(new ordinate(i, j, matrix[i][j]));
				}
			}
			
//			Collections.sort(list, new Comparator<ordinate>() {
//					@Override
//					public int compare(ordinate o1, ordinate o2) {
//						return (o2.wt - o1.wt);
//					}
//				});
			
			Collections.sort(list, (s1,s2) -> { return (s2.wt - s1.wt);});
			
			//Now iterate through the list
			for(ordinate o : list) {
				if(!isVisited[o.x][o.y]) {
					dfsUtil(o.x,o.y,matrix);
					System.out.println(o.x + " " + o.y);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(3);
		int [][] matrix = { {1,2,3},
							{2,3,1},
							{1,1,1} };
		g.dfs(matrix);
	}
}
