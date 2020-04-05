package trees;

import java.util.Stack;

public class iterativeInorder {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void iterate(Node root) {
		if(root == null)
			return;
		
		Stack<Node> s = new Stack<>();

		Node curr = root;
		
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr  = s.pop();
			System.out.println(curr.data);
			curr = curr.right;
			
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
