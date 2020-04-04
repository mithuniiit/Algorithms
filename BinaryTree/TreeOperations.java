package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {
	
	static Node root;
	
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
	}

	public static void insert(int data) {
		if(root == null) {
			root = new Node(data);
			return;
		}
		
		Queue<Node> q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left == null) {
				temp.left = new Node(data);
				break;
			}
			else if(temp.right == null) {
				temp.right = new Node(data);
				break;
			}
			q.add(temp.left);
			q.add(temp.right);
		}
	}
	
	
	public static void removeNode(Node node) {
		Queue<Node> q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left != null) {
				if(temp.left == node) {
					temp.left = null;
					return;
				}
				q.add(temp.left);
			}
			if(temp.right != null) {
				if(temp.right == node) {
					temp.right = null;
					return;
				}
				q.add(temp.right);
			}
		}
	}
	
	
	public static void delete(int data) {
		if(root == null)
			return;
		
		if(root.left == null && root.right == null) {
			if(root.data == data)
				root = null;
		}
		
		//KeyNode will have node
		//lastNode will have last node
		Node keyNode = null;
		Node lastNode = null;
		Node temp = null;
		
		Queue<Node> q = new LinkedList();
		
		q.add(root);
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.data == data) {
				keyNode = temp;
			}
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);				
		}
		
		if(keyNode != null) {
			keyNode.data = temp.data;
		}
		
		//delink parent of temp
		removeNode(temp);
	}
	
	public static void print() {
		Queue<Node> q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		insert(1);
		insert(2);
		insert(3);
		insert(4);
		System.out.println("Before Deletion");
		print();
		delete(3);
		System.out.println("After Deletion");
		print();
	}
}
