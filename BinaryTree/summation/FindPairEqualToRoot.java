package trees.summation;

import java.util.HashSet;

public class FindPairEqualToRoot {

	public static boolean findPairUtil(Node root, HashSet<Integer>hs, int rootData) {
		if(root == null)
			return false;
		
		int rem = rootData - root.data;
		if(hs.contains(rem))
			return true;
		
		hs.add(root.data);
		
		return findPairUtil(root.left, hs, rootData) || findPairUtil(root.right, hs, rootData);
		
	}
	
	public static void findPair(Node root) {
		HashSet<Integer> hs = new HashSet<>();
		System.out.println(findPairUtil(root,hs,root.data));
	}
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(8);
		
		findPair(root);
	}
}
