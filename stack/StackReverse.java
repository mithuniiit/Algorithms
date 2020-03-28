package stack;

import java.util.Stack;

public class StackReverse {

	static Stack<Integer> s;
	
	public static void reverse() {
		if(s.size() > 0) {
			int x = s.peek();
			s.pop();
			reverse();
			insertBottom(x);
		}
	}
	
	
	private static void insertBottom(int x) {
		if(s.isEmpty()) {
			s.push(x);
		}else {
			int temp = s.pop();
			insertBottom(x);
			s.push(temp);
		}
	}


	public static void main(String[] args) {
		s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		reverse();
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
