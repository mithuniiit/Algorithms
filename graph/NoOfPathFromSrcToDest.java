package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfPathFromSrcToDest {

	static class graph{
		ArrayList<ArrayList<Integer>> adj;
		int V;

		graph(int V){
			this.V = V;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<V;i++) {
				adj.add(new ArrayList<Integer>());
			}
		}

		void addEdge(int src,int dest) {
			adj.get(src).add(dest);
		}

		boolean isVisited(ArrayList<Integer>path, int vertex) {
			return path.contains(vertex);
		}

		void printBFS(int src,int dest) {
			Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(src);
			q.add(path);
			while(!q.isEmpty()) {
				path = q.poll();
				int lastVertex = path.get(path.size()-1);

				if(lastVertex == dest) {
					System.out.println(path);
					continue;
				}

				for(Integer i : adj.get(lastVertex)) {
					if(!isVisited(path,i)) {
						ArrayList<Integer> newPath = new ArrayList<>();
						newPath.addAll(path);
						newPath.add(i);
						q.add(newPath);
					}
				}
			}
		}
		
		public void printDFSUtil(int src, int dest, ArrayList<Integer>path, boolean[] isVisited) {
			isVisited[src] = true;
			path.add(src);
			
			if(src == dest) {
				System.out.println(path);
				return;
			}
			
			for(Integer i : adj.get(src)) {
				if(!isVisited[i]) {
					printDFSUtil(i,dest,path,isVisited);
					path.remove(path.size()-1);
					isVisited[i] = false;
				}
			}
		}
		
		public void printDFS(int src, int dest) {
			ArrayList<Integer>path = new ArrayList<>();
			boolean isVisited[] = new boolean[V];
			
			printDFSUtil(src,dest,path,isVisited);
		}
	}

	public static void main(String[] args) {
		graph g = new graph(4);
		g.addEdge(0,2);
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(2,0);
		g.addEdge(2,1);
		g.addEdge(1,3);
		//g.printBFS(2,3);
		g.printDFS(2,3);
	}

}
