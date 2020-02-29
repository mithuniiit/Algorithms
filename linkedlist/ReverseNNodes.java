package Linkedlist;

public class ReverseNNodes {

	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public static Node reverseNodes(Node localhead, int k) {
		Node current = localhead;
		Node prev = null;
		Node next = null;
		int count = 0;
		
		while(count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null)
			localhead.next = reverseNodes(next,k);
		
		return prev;
		
	}
	
	public static void printNodes() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head = reverseNodes(head, 2);
		printNodes();
	}
}
