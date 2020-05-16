package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToReachTargetByKnight {

	static class cell{
		int x;
		int y;
		int dis;
		
		public cell(int x, int y, int dis) {
			this.dis = dis;
			this.x = x;
			this.y = y;
		}
	}

	static boolean isSafe(int x, int y, boolean[][] isVisited, int N) {
		if(x>=0 && x<N+1 && y>=0 && y<N+1 && isVisited[x][y] == false)
			return true;
		return false;
	}
	
	
	static int findMinCount(int srcX, int srcY, int tarX, int tarY, int N) {
		boolean[][] isVisited = new boolean[N+1][N+1];
	    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};  
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};  
	    
	    Queue<cell> q = new LinkedList<>();
	    q.add(new cell(srcX,srcY,0));
	    isVisited[srcX][srcY] = true;
	    
	    while(!q.isEmpty()) {
	    	cell c = q.poll();
	    	
	    	if(c.x == tarX && c.y == tarY) {
	    		return c.dis;
	    	}
	    	
	    	for(int i=0; i<dx.length; i++) {
	    		if(isSafe(c.x+dx[i],c.y+dy[i], isVisited, N)) {
	    			isVisited[c.x+dx[i]][c.y+dy[i]] = true;
	    			q.add(new cell(c.x+dx[i],c.y+dy[i],c.dis+1));
	    		}
	    	}
	    }
	    
	    return -1;
	}
	
	public static void main(String[] args) {
		int N = 30;
		int srcX = 1;
		int srcY = 1;
		int tarX = 30;
		int tarY = 30;
		System.out.println(findMinCount(srcX, srcY, tarX, tarY, N));
	}
}
