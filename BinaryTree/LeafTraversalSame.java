package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.ChildrenSum.Node;

public class LeafTraversalSame {
	
	public static void getLeaf(Node root, Queue<Node> q){
		if(root != null) {
			getLeaf(root.left,q);
			if(root.left == null && root.right==null)
				q.add(root);
			getLeaf(root.right,q);
		}
	}
	
	public static boolean isLeafSame(Node root1, Node root2) {
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		
		getLeaf(root1,q1);
		getLeaf(root2,q2);
		
		if(q1.size() != q2.size())
			return false;
		
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(q1.poll().data != q2.poll().data)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		
		Node root2 = new Node(7);
		root2.left = new Node(8);
		root2.right = new Node(9);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.right.left = new Node(6);
		
		System.out.println(isLeafSame(root1,root2));
	}
	

}
