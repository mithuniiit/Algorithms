package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.CousineNode.Node;

public class IsBinaryTreeComplete {
	
	public static boolean isComplete(Node root) {
		
		if(root == null)
			return true;
		
		boolean flag = false;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp.left != null) {
				
				if(flag == true)
					return false;
				
				q.add(temp.left);
			}else
				flag = true;
			
			if(temp.right != null) {
				
				if(flag == true)
					return false;
				
				q.add(temp.right);
			}else
				flag = true;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		//root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isComplete(root));
	}
}
