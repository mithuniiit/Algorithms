package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse {
	static Queue<Integer> q = new LinkedList<>();
	
	private static void reverseQueue() {
		Stack<Integer> s = new Stack<>();
		while(!q.isEmpty()) {
			s.push(q.poll());
		}
		
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
	}
	
	
	public static void main(String[] args) {
		q.add(10); 
        q.add(20); 
        q.add(30); 
        q.add(40); 
        q.add(50); 
        q.add(60); 
        q.add(70); 
        q.add(80); 
        q.add(90); 
        q.add(100); 
        
        reverseQueue();
        while(!q.isEmpty())
        	System.out.println(q.poll());
	}
}
