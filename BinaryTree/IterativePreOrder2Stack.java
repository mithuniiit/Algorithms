package trees;

import java.util.Stack;

public class IterativePreOrder2Stack {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static void iterate(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		/*
		 	Here is the algorithm
			1.Add child nodes to s1, left - right
			2.Pop s1 and add children to s1 and current node to s2
			3.iterate till stack is empty.
		*/
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.left != null) {
				s1.push(temp.left);
			}
			
			if(temp.right != null) {
				s1.push(temp.right);
			}
		}
		
		//Now pop all the elements of s2 and print
		while(!s2.isEmpty()) {
			System.out.println(s2.pop().data);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		iterate(root);
	}

}
