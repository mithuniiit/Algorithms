package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReversePath {

	static Queue<Integer> q = new LinkedList();
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(7);
		root.left = new Node(6);
		root.right = new Node(5);
		root.left.left = new Node(4);
		root.left.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(1);
		
		//printInorder(root);
		reversePathFromRoot(4,root);
		printInorder(root);
	}
	
	private static boolean reversePathFromRoot(int ele,Node root) {
		if(root == null) {
			return false;
		}
		
		q.add(root.data);
		
		if(root.data == ele) {
			root.data = q.poll();
			return true;
		}
		
		boolean left = reversePathFromRoot(ele,root.left);
		
		if(left) {
			root.data = q.poll();
			return left;
		}
		
		boolean right = reversePathFromRoot(ele,root.left);
		
		if(right) {
			root.data = q.poll();
			return right;
		}
		
		q.poll();
		return false;
	}

	private static void printInorder(Node root) {
		if(root == null)
			return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	
}
