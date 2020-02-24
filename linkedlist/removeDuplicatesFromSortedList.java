package Linkedlist;

public class removeDuplicatesFromSortedList {

	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int x) {
			this.data = x;
		}
	}
	
	public static void removeDuplicate() {
		Node prev = head;
		Node curr = head;
		
		while(curr != null) {
			prev = curr;
			curr=curr.next;
			if(curr!=null && prev.data == curr.data) {
				prev.next = curr.next;
			}
		}
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(3);
		printNode();
		removeDuplicate();
		System.out.println();
		printNode();
	}

	private static void printNode() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
