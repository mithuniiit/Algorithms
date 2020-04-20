package trees;

import trees.CousineNode.Node;

public class IsPerfect {
	
	
	public static boolean isPerfRec(Node root, int height, int depth) {
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return (depth+1 == height);
		
		if(root.left == null || root.right == null)
			return false;
		
		return isPerfRec(root.left,height,depth+1) && isPerfRec(root.right,height,depth+1);
	}
	
	public static int findHeight(Node root) {
		if(root == null)
			return 0;
		
		return (findHeight(root.left)+1);
	}
	
	
	public static boolean isPerfectBinary(Node root) {
		int height = findHeight(root);
		
		return isPerfRec(root,height,0);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isPerfectBinary(root));
	}

}
