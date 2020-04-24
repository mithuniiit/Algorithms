package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.isSymmetrc.Node;

public class IsSymmetricIterative {
	
	
	public static boolean checkIterative(Node root) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root.left);
		q.add(root.right);
		
		while(!q.isEmpty()) {
			
			Node left = q.poll();
			Node right = q.poll();
			
			if(left == null && right == null)
				return true;
			
			if( (left == null && right != null) || (left != null && right == null))
				return false;
			
			
			if(left.data != right.data)
				return false;
			
			q.add(left.left);
			q.add(right.right);
			q.add(left.right);
			q.add(right.left);
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		System.out.println(checkIterative(root));
	}

}
