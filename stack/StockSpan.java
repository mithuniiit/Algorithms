package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	
	public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 }; 
        int n = price.length;
        int s[] = new int[n];
        
        calculateSpan(price,n,s);
        
        System.out.println(Arrays.toString(s));
	}


	private static void calculateSpan(int[] price, int n, int[] s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		s[0] = 1;
		
		for(int i=0;i<n;i++) {
			while( !stack.isEmpty() && price[stack.peek()] < price[i]) {
				stack.pop();
			}
			
			s[i] = (stack.isEmpty()) ? (i+1) : (i - stack.peek());
			stack.push(i);
		}
	}
}
