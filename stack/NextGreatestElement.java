package stack;

import java.util.Stack;

public class NextGreatestElement {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int arr[] = { 11, 13, 21, 3 }; 
        int n = arr.length; 
        findNGE(s,arr,n);
	}

	private static void findNGE(Stack<Integer> s, int[] arr, int n) {
		s.push(arr[0]);
		
		for(int i=1;i<n;i++) {
			while(!s.isEmpty() && s.peek()<arr[i]) {
				System.out.println("NGE of "+s.pop()+" is "+arr[i]);
			}
			s.push(arr[i]);
		}
		
		if(!s.isEmpty()) {
			System.out.println("NGE of "+s.peek()+" is -1");
		}
	}
}
