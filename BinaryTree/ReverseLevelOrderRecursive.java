package trees;

import trees.TwoLevelOrder.Node;

public class ReverseLevelOrderRecursive {

	
	public static void printRecurUtil(Node root, int height) {
		if(root == null)
			return;
		if(height == 0)
			System.out.println(root.data);
		printRecurUtil(root.left, height-1);
		printRecurUtil(root.right, height-1);
	}
	
	public static void printRecur(Node root,int height) {
		for(int i=height;i>=0;i--) {
			printRecurUtil(root,i);
		}
		
	}
	
	public static int findHeight(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(findHeight(root.left)+1, findHeight(root.right)+1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int height = findHeight(root);
		printRecur(root,height);
	}
}
