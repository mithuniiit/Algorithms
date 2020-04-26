package trees.summation;

import java.util.ArrayList;
import java.util.Stack;

public class MaxSprialSum {

	
	public static int max(ArrayList<Integer> arr) {
		//Global max
		int max_so_far = Integer.MIN_VALUE;
		
		//local max
		int max_ending_here = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.size(); i++)
			System.out.println(arr.get(i));
		
		for(int i=0 ; i<arr.size(); i++) {
			
			if(max_ending_here < 0)
				max_ending_here = arr.get(i);
			else
				max_ending_here += arr.get(i);
			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		return max_so_far;
	}
	
	
	public static int maxSum(Node root) {
		//Take 2 stacks first stack movies left to right and other right to left
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				arr.add(temp.data);
				if(temp.left != null)
					s2.push(temp.left);
				if(temp.right != null)
					s2.push(temp.right);
			}
			
			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				arr.add(temp.data);
				if(temp.right != null)
					s1.push(temp.right);
				if(temp.left != null)
					s1.push(temp.left);
			}
		}
		
		return max(arr);
	}
	public static void main(String[] args) {
		Node root = new Node(-2); 
        root.left = new Node(-3); 
        root.right = new Node(4); 
        root.left.left = new Node(5); 
        root.left.right = new Node(2); 
        root.right.left = new Node(-2); 
        root.right.right = new Node(-1);
        root.left.left.left = new Node(-3);
        root.right.right.right = new Node(2);
        
        System.out.println(maxSum(root));
	}
}
