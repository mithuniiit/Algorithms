package stack;

import java.util.ListIterator;
import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
        
        printStack(s);
        sort(s);
        System.out.println("After Sort");
        printStack(s);
	}

	private static void sort(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int x = s.pop();
			sort(s);
			sortInsert(s,x);
		}
		
	}

	private static void sortInsert(Stack<Integer> s, int x) {
		if(s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}
		
		int temp = s.pop();
		sortInsert(s,x);
		s.push(temp);
	}

	private static void printStack(Stack<Integer> s) {
		ListIterator<Integer> it = s.listIterator();
		
		while(it.hasNext())
			it.next();
		
		while(it.hasPrevious())
			System.out.println(it.previous());
		
	}
}
