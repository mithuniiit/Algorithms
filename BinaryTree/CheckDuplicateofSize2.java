package trees;

import java.util.HashSet;

import trees.CousineNode.Node;

public class CheckDuplicateofSize2 {
	
	static char MARKER = '$';
	
	public static String check(Node root,HashSet subTree) {
		
		String s = "";
		
		if(root == null)
			return s+MARKER;
		
		String lsubString = check(root.left,subTree);
		if(lsubString.equals(s))
			return s;
		
		String rsubString = check(root.right,subTree);
		if(rsubString.equals(s))
			return s;
		
		s = s + root.data + lsubString + rsubString;
		
		if(s.length()>3 && subTree.contains(s)) {
			return "";
		}

		subTree.add(s);
		return s;
	}

	public static void main(String[] args) {
		
//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.right = new Node(2);
//		root.right.right.left = new Node(4);
//		root.right.right.right = new Node(5);

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(3);
		
		
		HashSet<String> subTree = new HashSet<>();
		String str = check(root,subTree);
		if(str.equals(""))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
