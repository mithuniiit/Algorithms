package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.CousineNode.Node;

public class IsPerfectIterative {
	
	public static boolean isIterative(Node root) {
		Queue<Node> q = new LinkedList();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left == null && temp.right == null)
				continue;
			
			if(temp.left == null || temp.right == null)
				return false;
			
			q.add(temp.left);
			q.add(temp.right);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isIterative(root));
	}

}
