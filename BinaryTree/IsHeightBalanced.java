package trees;

import trees.CousineNode.Node;

public class IsHeightBalanced {

	public static int isBalanced(Node root) {
		if(root == null)
			return 0;
		
		int lh = isBalanced(root.left);
		if(lh == -1)
			return -1;
		int rh = isBalanced(root.right);
		if(rh == -1)
			return -1;
		
		if(Math.abs(lh-rh) > 1)
			return -1;
		
		return (lh > rh) ? lh + 1 : rh + 1;
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
//		root.left.left.left = new Node(5);
//		root.left.left.left.left = new Node(6);
//		root.left.left.left.left.left = new Node(7);
		System.out.println(isBalanced(root));
	}
}
