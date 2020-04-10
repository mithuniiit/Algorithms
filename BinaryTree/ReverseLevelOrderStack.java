package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.TwoLevelOrder.Node;

public class ReverseLevelOrderStack {
	static void levelOrder(Node root,Queue<Node> q,Stack<Node> s) {
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			s.push(temp);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}

	public static void print(Stack<Node> s) {
		while(!s.isEmpty())
			System.out.println(s.pop().data);
	}

	public static void main(String[] args) {
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		levelOrder(root,q,s);
		print(s);

	}
}
