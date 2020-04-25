package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.LevelOrderByNewLine.Node;

public class PrintNodesAtOdd {


	public static void printOdd(Node root) {
		boolean isOdd = true;
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			int count = q.size();
			while(count-- > 0) {
				Node temp = q.poll();
				if(isOdd)
					System.out.println(temp.data);
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
			isOdd = !isOdd;
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
		printOdd(root);
	}
}
