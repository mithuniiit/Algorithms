package stack;

public class GetMin {

	static int[] s;
	static int min;
	static int top;
	
	public static void push(int x) {
		if(x < min) {
			s[++top] = 2*x - min;
			min = x;
		}else {
			s[++top] = x;
		}
			
	}
	
	public static int pop() {
		if(s[top] > min) {
			return s[top--];
		}
		int temp = min;
		min = 2 * min - s[top--];
		return temp;
	}
	
	public static int getMin() {
		return min;
	}
	
	public static void main(String[] args) {
		s = new int[100];
		min = Integer.MAX_VALUE;
		top = -1;
		push(1);
		push(2);
		push(3);
		System.out.println(getMin());
		push(0);
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
	}
}
