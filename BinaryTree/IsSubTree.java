package trees;

import trees.CousineNode.Node;

public class IsSubTree {

	
	public static boolean areIdentical(Node t1, Node t2) {
		if(t1 == null && t2 == null)
			return true;
		
		if(t1 == null || t2 == null)
			return false;
		
		return(t1.data == t2.data && areIdentical(t1.left,t2.left) && areIdentical(t1.right,t2.right));
	}
	
	
	
	public static boolean checkSub(Node t, Node s) {
		if(s == null)
			return true;
		
		if(t == null)
			return false;
		
		if(areIdentical(t,s)) {
			return true;
		}
		
		return checkSub(t.left,s) || checkSub(t.right,s);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		Node subTree = new Node(2);
		subTree.left = new Node(4);
		subTree.right = new Node(5);
		
		System.out.println(checkSub(root,subTree));
	}
}
