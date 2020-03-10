package Linkedlist;

public class KthNodeFromEnd {
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static void printKthNode(Node head, int k) {
		Node fast = head;
		Node slow = head;
		while(k > 0) {
			fast = fast.next;
			k--;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println(slow.data);
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		printKthNode(head, 2);
	}

}
