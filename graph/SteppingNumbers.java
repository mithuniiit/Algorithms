//https://www.geeksforgeeks.org/stepping-numbers/

package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {

	static void bfs(int m, int n, int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			if(num < m || num > n)
				continue;
			
			if(num > m && num < n)
				System.out.println(num);
			
			int lastDigit = num%10;
			
			int stepNumA = num*10 + (lastDigit-1);
			int stepNumB = num*10 + (lastDigit+1);
			
			if(lastDigit == 0)
				q.add(stepNumB);
			else if(lastDigit == 9)
				q.add(stepNumA);
			else {
				q.add(stepNumA);
				q.add(stepNumB);
			}
				
		}
	}
	
	
	static void dfs(int m, int n, int num) {
		if(num < m || num > n)
			return;
		
		if(num > m && num < n)
			System.out.println(num);
		
		int lastDigit = num%10;
		
		int stepNumA = num*10 + (lastDigit-1);
		int stepNumB = num*10 + (lastDigit+1);
		
		if(lastDigit == 0)
			dfs(m,n,stepNumB);
		else if(lastDigit == 9)
			dfs(m,n,stepNumA);
		else {
			dfs(m,n,stepNumA);
			dfs(m,n,stepNumB);
		}
	}
	
	static void displaySteppingNumbers(int m, int n) {
		for(int i=0;i<=9;i++)
			bfs(m,n,i);
		
		System.out.println("DFS Below");
		for(int i=0;i<=9;i++)
			dfs(m,n,i);
	
	}
	
	public static void main(String[] args) {
		int m = 0, n= 21; 
		  
        // Display Stepping Numbers in 
        // the range [m,n] 
        displaySteppingNumbers(m,n); 
	}
}
