package verma.stack;

import java.util.Stack;

public class MaxAreaInBinaryHistogram {

	public MaxAreaInBinaryHistogram() {
		// TODO Auto-generated constructor stub
	}

	public static void findMaxAreaInBinaryMatrix(int[][] matrix) {
		if( matrix==null || matrix[0].length == 0) {
			System.out.println("No Solution");
		}
		
		int[] row = new int[matrix[0].length];
		int max = Integer.MIN_VALUE;
		
		
		for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0)
					row[j] = 0;
				else
					row[j] +=  1;
			}
			max = Math.max(max,maxAreaInHistogram(row));
		}
		
		System.out.println(max);
	}
	
	
	static int[] nser(int[] a) {
		int n = a.length;
		
		int[] result = new int[n];
		Stack<Integer>s = new Stack<>();

		for(int i=n-1; i>=0; i--) {
			while(!s.isEmpty() && a[s.peek()] >= a[i])
				s.pop();

			result[i] = s.isEmpty() ? n : s.peek();
			s.push(i);
		}
		return result;
	}
	
	
	static int[] nsel(int[] a) {
		int n = a.length;
		
		int[] result = new int[n];
		Stack<Integer> s = new Stack<>();

		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && a[s.peek()] >= a[i])
				s.pop();

			result[i] = s.isEmpty() ? -1 : s.peek();
			s.push(i);
		}
		return result;
	}
	
	public static int maxAreaInHistogram(int[] height){
		int []right = nser(height);
		int []left = nsel(height);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<height.length; i++) {
			max = Math.max(max, (right[i]-left[i]-1) * height[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { 
								{ 0, 1, 1, 0 }, 
								{ 1, 1, 1, 1 }, 
								{ 1, 1, 1, 1 }, 
								{ 1, 1, 0, 0 } 
						};
		
		findMaxAreaInBinaryMatrix(matrix);
	}
}
