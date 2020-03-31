package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZag {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public static void printZigZag(Node root) {
		boolean leftToRight = true;
		Node temp = null;
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			
			temp = q.poll();
			if(temp == null && !q.isEmpty())
				q.add(temp);
			
			if(leftToRight) {
				if(temp == null) {
					leftToRight = !leftToRight;
					continue;
				}
				else
					System.out.println(temp.data);
			}else {
				if(temp == null) {
					while(!s.isEmpty()) {
						System.out.println(s.pop().data);
					}
					leftToRight = !leftToRight;
					continue;
				}else {
					s.push(temp);
				}
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
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		printZigZag(root);
	}
	
	
}
