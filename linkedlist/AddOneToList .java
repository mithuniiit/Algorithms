package Linkedlist;

public class AddOneToList {

	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int x) {
			this.data = x;
		}
	}
	
	private static void printNode() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static void reverseList() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	private static void addOneToList() {
		//Reverse the list
		reverseList();
		
		//Do the addition
		Node temp = head;
		int carry = 1;
		int sum = 0;
		
		while(temp!=null) {
			sum = temp.data + carry;
			carry = sum/10;
			temp.data = sum%10;
			temp = temp.next;
		}
		
		//Reverse the list again.
		reverseList();
	} 

	
	
	public static void main(String [] args) 
    { 
		head = new Node(1);
		head.next = new Node(9);
		head.next.next = new Node(9);
		head.next.next.next = new Node(9);
        printNode();
        addOneToList();
        printNode();
    }
}
