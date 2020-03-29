package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class node{
		int data;
		node left;
		node right;
		node(int data){
			this.data = data;
		}
	}
	
	public static void levelTraversal(node root) {
		Queue<node> q = new LinkedList();
		q.add(root);
		
		while(!q.isEmpty()) {
			node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		node root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		root.right.left = new node(6);
		root.right.right = new node(7);
		levelTraversal(root);
	}
}
