package queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromLinkedList {

	static Node head;
	static TNode root;
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	static class TNode{
		int data;
		TNode left,right;
		TNode(int data){
			this.data = data;
		}
	}
	
	public static void buildTreeFromList() {
		Queue<TNode> q = new LinkedList<>(); 
		
		if(head == null)
			return;
		
		//Add head to queue
		root = new TNode(head.data);
		q.add(root);
		
		Node listTemp = head;
		
		while(listTemp != null) {
			TNode parent = q.poll();
			
			//Parent.left
			if(listTemp.next == null)
				break;
			
			listTemp = listTemp.next;
			TNode node = new TNode(listTemp.data);
			parent.left = node;
			q.add(node);
			
			//Parent.right
			if(listTemp.next == null)
				break;
			
			listTemp = listTemp.next;
			node = new TNode(listTemp.data);
			parent.right = node;
			q.add(node);
		}
	}
	
	public static void printInorder(TNode root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	
	
	public static void main(String[] args) {
		head = new Node(10);
		head.next = new Node(12);
		head.next.next = new Node(15);
		head.next.next.next = new Node(25);
		head.next.next.next.next = new Node(30);
		head.next.next.next.next.next = new Node(36);
		buildTreeFromList();
		printInorder(root);
	}
}
