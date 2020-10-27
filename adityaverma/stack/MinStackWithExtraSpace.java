package verma.stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

	static Stack<Integer> s = new Stack<Integer>();
	static Stack<Integer> ss = new Stack<Integer>();
	
	public MinStackWithExtraSpace() {
		// TODO Auto-generated constructor stub
	}
	
	public static void push(int ele) {
		s.push(ele);
		
		if(ss.isEmpty() || (!ss.isEmpty()  && ss.peek() > ele))
			ss.push(ele);
	}
	
	public static int pop() {
		if(s.isEmpty()) {
			System.out.println("No Elements");
			return Integer.MIN_VALUE;
		}
		
		if(!ss.isEmpty()  && ss.peek() == s.peek()) {
			ss.pop();
		}
		
		return s.pop();
	}
	
	public static int getMin() {
		if(ss.isEmpty())
			return Integer.MIN_VALUE;
		
		return ss.peek();
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		System.out.println(getMin());
		System.out.println(pop());
		System.out.println(getMin());
	}

}
