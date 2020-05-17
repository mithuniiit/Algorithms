package graphs;

import java.util.LinkedList;
import java.util.Queue;

class cell {
	int val;
	int steps;

	cell(int val, int steps){
		this.val = val;
		this.steps = steps;
	}
}


public class MinNumOfOperationsToConvertXToY {

	private int convert(int x, int y) {
		
		Queue<cell> q = new LinkedList<>();
		cell temp = new cell(x,0);
		q.add(temp);
		
		while(!q.isEmpty()) {
			temp = q.poll();
			
			if(temp.val == y) {
				return temp.steps;
			}
			
			q.add(new cell(temp.val*2,temp.steps+1));
			q.add(new cell(temp.val-1,temp.steps+1));
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int x = 4, y = 7;
		MinNumOfOperationsToConvertXToY op = new MinNumOfOperationsToConvertXToY();
		System.out.println(op.convert(x,y));
	}
}
