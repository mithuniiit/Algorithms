package BinaryTree;

import BinaryTree.levelOrder.Node;

public class Diameter {

	
	public static int findHeight(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(findHeight(root.left),findHeight(root.right))+1;
	}
	public static int findDiameter(Node root) {
		
		if(root == null)
			return 0;
		
		int lh = findHeight(root.left);
		int rh = findHeight(root.right);
		
		int ld = findDiameter(root.left);
		int rd = findDiameter(root.right);
		
		return( Math.max(lh+rh+1, Math.max(ld,rd)));
		
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		System.out.println(findDiameter(root));
	}
}
