package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSpecificPerfectBinaryTree {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void print(Node root) {
		Queue<Node> q = new LinkedList();
		
		if(root == null)
			return;
		
		System.out.println(root.data);
		
		if(root.left != null) {
			System.out.println(root.left.data);
			System.out.println(root.right.data);
		}
		
		if(root.left.left == null)
			return;
		
		q.add(root.left);
		q.add(root.right);
		
		Node first = null, second = null;
		
		while(!q.isEmpty()) {
			first = q.poll();
			second = q.poll();
			
			System.out.println(first.left.data);
			System.out.println(second.right.data);
			System.out.println(first.right.data);
			System.out.println(second.left.data);
			
			if(first.left.left != null) {
				q.add(first.left); 
                q.add(second.right); 
                q.add(first.right); 
                q.add(second.left); 
			}
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
