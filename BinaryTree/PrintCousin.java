package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.LevelOrderByNewLine.Node;

public class PrintCousin {
	
	
	public static void printCousine(Node root, int key) {
		
		if(root == null)
			System.out.println("No Cousine");
		
		if(root.data == key)
			System.out.println("No Cousine");
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if( (temp.left != null && temp.left.data == key) || (temp.right != null && temp.right.data == key)) {
				while(!q.isEmpty()) {
					temp = q.poll();
					if(temp.left != null)
						System.out.println(temp.left.data);
					if(temp.right != null)
						System.out.println(temp.right.data);
				}
				return;
			}
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
				
		}
			
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printCousine(root,4);
	}
}
