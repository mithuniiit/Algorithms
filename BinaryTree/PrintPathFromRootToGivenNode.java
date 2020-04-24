package BinaryTree;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.levelOrder.Node;

public class PrintPathFromRootToGivenNode {

	public static boolean print(Node root, List<Node> l, int key) {
		if(root == null)
			return false;
		
		l.add(root);
		
		if(root.data == key)
			return true;
		
		if( print(root.left,l,key) || 	print(root.right,l,key))
			return true;
		
		l.remove(l.size()-1);
		return false;
		
	}
	
	public static void main(String[] args) {
		List<Node> l = new ArrayList<Node>();
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		print(root,l,8);
		
		for(Node itr : l) {
			System.out.println(itr.data);
		}
	}
}
