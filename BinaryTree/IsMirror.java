package trees;

import trees.LevelOrderByNewLine.Node;

public class IsMirror {
	
	
	public static boolean check(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return root1.data == root2.data && check(root1.left,root2.right) && check(root1.right,root2.left); 
	}
	
	
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		
		Node root2 = new Node(1);
		root2.right = new Node(2);
		root2.left = new Node(3);
		root2.right.right = new Node(4);
		root2.right.left = new Node(5);
		
		System.out.println(check(root1, root2));
	}

}
