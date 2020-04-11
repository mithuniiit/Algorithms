package trees;

import java.util.Stack;

public class IterativePostOrder1Stack {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void iterate(Node root) {
		Stack<Node> s = new Stack<>();
		
		while(true) {
			
			while(root != null) {
				s.push(root);
				s.push(root);
				root = root.left;
			}
			
			if(s.isEmpty()) return;
			
			root = s.pop();
			
			if(!s.empty() && s.peek() == root)
				root = root.right;
			else {
				System.out.println(root.data);
				root=null;
			}
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
