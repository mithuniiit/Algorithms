package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToReachEndOfArray {

	static int bfs(int[] arr, int N) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i =0; i<N; i++)
			adj.add(new ArrayList<Integer>());
		
		for(int i=0; i<N; i++) {
			adj.get(arr[i]).add(i);
			if(i>=1)
				adj.get(arr[i]).add(i-1);
			if(i<N-1)
				adj.get(arr[i]).add(i+1);
			
		}
		
		int []dist = new int[N];
		boolean[] isVisited = new boolean[N];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		dist[0]=0;
		isVisited[0] = true;
		
		while(!q.isEmpty()) {
			int u = q.poll();
			
			for(Integer v : adj.get(u)) {
				if(!isVisited[v]) {
					q.add(v);
					dist[v] = dist[u]+1;
					isVisited[v] = true;
				}
			}
			
//			if(u-1>=0 && !isVisited[u-1]) {
//				q.add(u-1);
//				dist[u-1] = dist[u]+1;
//				isVisited[u-1] = true;
//			}
//			
//			if(u+1<N && !isVisited[u+1]) {
//				q.add(u+1);
//				dist[u+1] = dist[u]+1;
//				isVisited[u+1] = true;
//			}
		}
		
		return dist[N-1];
	}
	
	
	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7}; 
		int N = arr.length;
		System.out.println(bfs(arr,N));
	}
}
