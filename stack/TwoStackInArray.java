package stack;

public class TwoStackInArray {
	
	int[] arr;
	int size;
	int top1,top2;
	
	TwoStackInArray(int n){
		this.size = n;
		arr = new int[n];
		top1 = -1;
		top2 = n;
	}
	
	void push1(int data) {
		if(top1 >= top2)
			System.out.println("Stack Full");
		else {
			arr[++top1] = data; 
		}
	}
	
	
	int pop1() {
		if(top1 == -1) {
			System.out.println("Stack Empty");
			return Integer.MIN_VALUE;
		}
		return arr[top1--];
	}
	
	void push2(int data) {
		if(top2 <= top1)
			System.out.println("Stack Full");
		else {
			arr[--top2] = data; 
		}
	}
	
	
	int pop2() {
		if(top2 == size) {
			System.out.println("Stack Empty");
			return Integer.MIN_VALUE;
		}
		return arr[top2--];
	}
	
	
	public static void main(String[] args) {
		TwoStackInArray s = new TwoStackInArray(10);
		s.push1(1);
		s.push1(2);
		System.out.println(s.pop1());
		System.out.println(s.pop1());
		System.out.println(s.pop1());
		
		s.push2(1);
		s.push2(2);
		System.out.println(s.pop2());
		System.out.println(s.pop2());
		System.out.println(s.pop2());
		
	}
}
