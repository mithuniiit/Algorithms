package trees;

import java.util.Stack;

public class IterativePreOrder {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}

	public static void iterate(Node root) {
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node temp = s.pop();
			System.out.println(temp.data);
			
			//First push right and then left as when we pop we get
			//in correct order.
			if(temp.right != null)
				s.push(temp.right);
			
			if(temp.left != null)
				s.push(temp.left);
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
