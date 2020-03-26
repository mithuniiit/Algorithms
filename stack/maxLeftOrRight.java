package stack;

import java.util.Stack;

public class maxLeftOrRight {
	public static void main(String[] args) {
        int []arr = new int[]{ 5, 4, 3, 4, 5 }; 
        int n = arr.length; 
        LRProduct(arr, n); 
	}

	//Algo lets have array of index of NGE of both left and right
	private static void LRProduct(int[] arr, int n) {
		int[] left = new int[n];
		int[] right = new int[n];
		findLeft(arr,n,left);
		findRight(arr,n,right);
		for(int i=0 ;i<n;i++) {
			System.out.println(left[i] * right[i]);
		}
	}

	private static void findLeft(int[] arr, int n, int[] left) {
		Stack<Integer> s = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
				left[s.pop()] = i;
			}
			s.push(i);
		}
	}
	
	private static void findRight(int[] arr, int n, int[] right) {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
				right[s.pop()] = i;
			}
			s.push(i);
		}
	}
}
