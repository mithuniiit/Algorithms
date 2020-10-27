package verma.stack;

import java.util.Stack;

public class MaxAreaInHistogram {

	public MaxAreaInHistogram() {
		// TODO Auto-generated constructor stub
	}


	static int[] nser(int[] a) {
		int n = a.length;
		
		int[] result = new int[n];
		Stack<Integer>s = new Stack<>();

		for(int i=n-1; i>=0; i--) {
			while(!s.isEmpty() && a[s.peek()] > a[i])
				s.pop();

			result[i] = s.isEmpty() ? n : s.peek();
			s.push(i);
		}
		return result;
	}
	
	static int[] nsel(int[] a) {
		int n = a.length;
		
		int[] result = new int[n];
		Stack<Integer>s = new Stack<>();

		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && a[s.peek()] > a[i])
				s.pop();

			result[i] = s.isEmpty() ? -1 : s.peek();
			s.push(i);
		}
		return result;
	}
	
	public static void maxArea(int[] height){
		int []right = nser(height);
		int []left = nsel(height);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<height.length; i++) {
			max = Math.max(max, (right[i]-left[i]-1) * height[i]);
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		int[] height = {6,2,5,4,5,1,6};
		maxArea(height);
	}
}
