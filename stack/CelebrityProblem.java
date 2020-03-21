package stack;

import java.util.Stack;

public class CelebrityProblem {

	static int MATRIX[][] = { { 0, 0, 1, 0 }, 
							  { 0, 0, 1, 0 }, 
							  { 0, 0, 0, 0 },  
							  { 0, 0, 1, 0 } }; 
	
	
	public static void main(String[] args) {
		System.out.println(findCelebrity());
	}


	private static int findCelebrity() {
		int n = MATRIX.length;
		Stack<Integer> s = new Stack<>();
		for(int i=0 ; i<n; i++) {
			s.push(i);
		}
		
		while(s.size() > 1) {
			int a = s.pop();
			int b = s.pop();
			
			if(knows(a,b)) {
				s.push(b);
			}else {
				s.push(a);
			}
		}
		
		int c = s.pop();
		for(int i=0; i<n ;i++) {
			if( i!=c && knows(c,i) && !knows(i,c)) {
				return -1;
			}
		}
		
		return c;
	}


	private static boolean knows(int a, int b) {
		if(MATRIX[a][b] == 1)  // a knows b -- b need not know a
			return true;
		return false;	// a doesnt know b -- then b cannot be celebrity.
	}
}
