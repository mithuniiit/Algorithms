package queue;

import java.util.LinkedList;
import java.util.Queue;

public class BFSInGraph {
	
	static int[][] graph;
	static int numVertex;
	
	public static void add(int src, int dest) {
		graph[src][dest] = 1;
		graph[dest][src] = 1;
	}
	
	public static void bfs(int src) {
		Queue<Integer> q = new LinkedList();
		boolean[] isVisited = new boolean[numVertex];
		q.add(src);
		isVisited[src] = true;
		System.out.println("BFS is ");
		while(!q.isEmpty()) {
			int vertex = q.poll();
			System.out.println(vertex);
			for(int i=0;i<numVertex;i++) {
				if(i!=vertex && graph[vertex][i] == 1 && !isVisited[i]) {
					q.add(i);
					isVisited[i]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		numVertex = 4;
		graph = new int[numVertex][numVertex];
		add(0,1);
		add(0,2);
		add(1,2);
		add(1,3);
		add(2,3);
		
		bfs(0);
	}
	
}
