package trees;

import trees.LevelOrderByNewLine.Node;

public class PrintMiddleOfNBinaryTree {

	
	public static void printMiddle(Node root1, Node root2) {
		if(root1 == null || root2 == null)
			return;
		
		if(root2.left == null && root2.right == null) {
			System.out.println(root1.data);
			return;
		}
		
		printMiddle(root1.left, root2.left.left);
		printMiddle(root1.right, root2.right.right);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printMiddle(root,root);
	}
}
