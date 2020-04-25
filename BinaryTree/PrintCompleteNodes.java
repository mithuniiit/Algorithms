package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.LevelOrderByNewLine.Node;

public class PrintCompleteNodes {


	public static void print(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left != null && temp.right != null) {
				System.out.println(temp.data);
				q.add(temp.left);
				q.add(temp.right);
			}
			else if(temp.left != null)
				q.add(temp.left);
			else if(temp.right != null)
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
		print(root);
	}
}
