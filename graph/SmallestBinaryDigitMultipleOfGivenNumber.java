//https://www.geeksforgeeks.org/find-the-smallest-binary-digit-multiple-of-given-number/

package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestBinaryDigitMultipleOfGivenNumber {

	static void findNumber(int N) {
		//seed is 1
		Queue<Integer> q = new LinkedList();
		q.add(1);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x%N == 0) {
				System.out.println(x);
				return;
			}
			
			q.add(x*10);
			q.add(x*10 + 1);
		}
	}
	
	public static void main(String[] args) {
		int N = 12;
		findNumber(N);
	}
	
}
