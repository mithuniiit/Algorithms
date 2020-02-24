package Linkedlist;

public class DeleteMiddle {
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int x) {
			this.data = x;
		}
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		deleteMiddle();
		printNode();
	}

	private static void deleteMiddle() {
		Node fastPtr=head;
		Node slowPtr=head;
		Node prev=head;
		
		while(fastPtr != null && fastPtr.next != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		prev.next = prev.next.next;
	}
	
	private static void printNode() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
